package com.osung.githubrepository.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.osung.githubrepository.repository.entity.GithubRepository

interface SearchRepository {
    fun searchRepositoryPage(query: String): LiveData<PagingData<GithubRepository>>
}