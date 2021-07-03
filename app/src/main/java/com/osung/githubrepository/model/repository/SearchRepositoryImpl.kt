package com.osung.githubrepository.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.paging.*
import com.osung.githubrepository.PAGE_SIZE
import com.osung.githubrepository.model.datasource.SearchDataSource
import com.osung.githubrepository.model.remote.RepositoryPagingDataSource
import com.osung.githubrepository.repository.SearchRepository
import com.osung.githubrepository.repository.entity.GithubRepository
import com.osung.githubrepository.repository.mapper

class SearchRepositoryImpl(
    private val remote: SearchDataSource
) : SearchRepository {
    override fun searchRepositoryPage(query: String): LiveData<PagingData<GithubRepository>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                initialLoadSize = PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { RepositoryPagingDataSource(query, remote) }
        ).liveData
            .map { data -> data.map { it.mapper() } }
    }


}