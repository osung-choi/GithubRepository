package com.osung.githubrepository.model.remote

import com.osung.githubrepository.model.remote.data.ResponseRepositorySearchResult
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/search/repositories")
    fun requestSearchRepositories(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Single<ResponseRepositorySearchResult>

    companion object {
        const val baseUrl = "https://api.github.com"
    }
}