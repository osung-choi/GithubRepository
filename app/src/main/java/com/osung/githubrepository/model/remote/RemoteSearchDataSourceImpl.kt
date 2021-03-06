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
        val apiQuery = query.plus(" in:name") //검색어가 포함된 Repository 요청

        return api.requestSearchRepositories(apiQuery, page, perPage)
    }
}