package com.osung.githubrepository.model.datasource

import com.osung.githubrepository.model.remote.data.ResponseRepositorySearchResult
import io.reactivex.rxjava3.core.Single

interface SearchDataSource {
    /**
     * Repository 검색 요청
     *
     * @param query 검색어
     * @param page 페이지 번호
     * @param perPage 페이지 사이즈
     * @return
     */
    fun requestSearchRepositories(
        query: String,
        page: Int,
        perPage: Int
    ): Single<ResponseRepositorySearchResult>
}