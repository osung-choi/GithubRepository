package com.osung.githubrepository.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.osung.githubrepository.repository.SearchRepository
import com.osung.githubrepository.repository.entity.GithubRepository

class MainViewModel(
    private val repository: SearchRepository
): ViewModel() {

    private val inputQuery = MutableLiveData<String>()
    val githubRepositoryPage = Transformations.switchMap(inputQuery) { //
        searchGithubRepository(it)
    }.cachedIn(this)

    /**
     * 검색 버튼 클릭 이벤트
     *
     * @param query
     */
    fun btnSearchClick(query: String) {
        if(query.isNotBlank()) inputQuery.value = query
    }

    /**
     * Github Repository 검색
     *
     * @param query 검색어
     * @return PagingData 를 LiveData 형태로 반환
     */
    private fun searchGithubRepository(query: String): LiveData<PagingData<GithubRepository>> {
        return repository.searchRepositoryPage(query)
    }
}