package com.osung.githubrepository.model.remote

import com.osung.githubrepository.model.datasource.SearchDataSource
import com.osung.githubrepository.model.remote.data.ResponseRepositorySearchResult
import io.reactivex.rxjava3.core.Single

class RemoteSearchDataSourceImpl(
    private val api: Api
) : SearchDataSource {

    override fun requestSearchRepositories(
        query: String,
        page: Int,
        perPage: Int
    ): Single<ResponseRepositorySearchResult> {
        return api.requestSearchRepositories(query, page, perPage)
    }
}