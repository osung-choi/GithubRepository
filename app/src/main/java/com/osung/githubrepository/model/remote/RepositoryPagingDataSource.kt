package com.osung.githubrepository.model.remote

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.osung.githubrepository.model.datasource.SearchDataSource
import com.osung.githubrepository.model.remote.data.RepositorySearchResult
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException

class RepositoryPagingDataSource(
    private val query: String,
    private val remote: SearchDataSource,
): RxPagingSource<Int, RepositorySearchResult>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, RepositorySearchResult>> {
        val position = params.key?: 1

        return remote.requestSearchRepositories(query, position, params.loadSize)
            .subscribeOn(Schedulers.io())
            .map<LoadResult<Int, RepositorySearchResult>> { result ->
                LoadResult.Page(
                    data = result.searchResults,
                    prevKey = if(position == 1) null else position - 1,
                    nextKey = if(result.totalCount < position * params.loadSize) null else position + 1
                )
            }
            .onErrorReturn { e ->
                when(e) {
                    is IOException -> LoadResult.Error(e)
                    is HttpException -> LoadResult.Error(e)
                    else -> throw e
                }
            }
    }

    override fun getRefreshKey(state: PagingState<Int, RepositorySearchResult>) = 1
}