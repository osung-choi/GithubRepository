package com.osung.githubrepository.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.osung.githubrepository.repository.SearchRepository
import com.osung.githubrepository.repository.entity.GithubRepository

class MainViewModel(
    private val repository: SearchRepository
): ViewModel() {

    private val inputQuery = MutableLiveData<String>()
    val githubRepositoryPage = Transformations.switchMap(inputQuery) {
        searchGithubRepository(it)
    }

    fun btnSearchClick(query: String) {
        if(query.isNotBlank()) inputQuery.value = query
    }

    private fun searchGithubRepository(query: String): LiveData<PagingData<GithubRepository>> {
        return repository.searchRepositoryPage(query)
    }
}