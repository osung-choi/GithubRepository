package com.osung.githubrepository.view.adpater

import androidx.recyclerview.widget.DiffUtil
import com.osung.githubrepository.entity.GithubRepository

class RepositoryDiffUtil: DiffUtil.ItemCallback<GithubRepository>() {
    override fun areItemsTheSame(oldItem: GithubRepository, newItem: GithubRepository) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: GithubRepository, newItem: GithubRepository) = oldItem == newItem
}