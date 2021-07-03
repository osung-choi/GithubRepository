package com.osung.githubrepository.entity

data class Repository(
    val id: Long,
    val fullName: String,
    val description: String,
    val htmlUrl: String,
    val starCount: Int,
    val forkCount: Int
)
