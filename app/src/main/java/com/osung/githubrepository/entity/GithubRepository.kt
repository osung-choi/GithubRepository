package com.osung.githubrepository.entity

data class GithubRepository(
    val id: Long,
    val fullName: String,
    val description: String,
    val starCount: Int,
    val forkCount: Int
)