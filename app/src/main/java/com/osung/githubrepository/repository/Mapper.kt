package com.osung.githubrepository.repository

import com.osung.githubrepository.model.remote.data.RepositorySearchResult
import com.osung.githubrepository.repository.entity.GithubRepository


fun RepositorySearchResult.mapper(): GithubRepository {
    return GithubRepository(id, fullName, description, stargazersCount, forksCount)
}