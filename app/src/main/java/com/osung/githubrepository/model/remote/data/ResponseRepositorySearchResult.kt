package com.osung.githubrepository.model.remote.data
import com.google.gson.annotations.SerializedName


data class ResponseRepositorySearchResult(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val searchResults: List<RepositorySearchResult>,
    @SerializedName("total_count")
    val totalCount: Int
)

data class RepositorySearchResult(
    @SerializedName("description")
    val description: Any,
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("stargazers_count")
    val stargazersCount: Int
)