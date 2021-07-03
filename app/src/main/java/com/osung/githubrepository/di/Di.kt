package com.osung.githubrepository.di

import com.osung.githubrepository.model.remote.RemoteSearchDataSourceImpl
import com.osung.githubrepository.model.datasource.SearchDataSource
import com.osung.githubrepository.model.remote.Api
import com.osung.githubrepository.model.repository.SearchRepositoryImpl
import com.osung.githubrepository.repository.SearchRepository
import com.osung.githubrepository.view.MainViewModel
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val dataModule = module {
    single<SearchRepository> { SearchRepositoryImpl(get()) }
    single<SearchDataSource> { RemoteSearchDataSourceImpl(get()) }
}

val networkModule = module {
    single {
        Interceptor { chain ->
            chain.proceed(chain.request().newBuilder().apply {
                header("accept", "application/vnd.github.v3+json")
            }.build())
        }
    }

    single {
        OkHttpClient.Builder().apply {
            addInterceptor(get())
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }.build()
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Api.baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(get())
            .build()
            .create(Api::class.java)
    }
}