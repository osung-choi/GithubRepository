package com.osung.githubrepository.model.datasource

import com.osung.githubrepository.model.remote.data.ResponseRepositorySearchResult
import io.reactivex.rxjava3.core.Single

interface SearchDataSource {
    fun requestSearchRepositories(
        query: String,
        page: Int,
        perPage: Int
    ): Single<ResponseRepositorySearchResult>
}