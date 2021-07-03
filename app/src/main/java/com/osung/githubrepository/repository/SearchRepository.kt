package com.osung.githubrepository.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.osung.githubrepository.repository.entity.GithubRepository

interface SearchRepository {
    /**
     * Repository 검색 페이지 요청
     *
     * @param query 검색어
     * @return
     */
    fun searchRepositoryPage(query: String): LiveData<PagingData<GithubRepository>>
}