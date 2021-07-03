package com.osung.githubrepository.view.adpater

import androidx.recyclerview.widget.DiffUtil
import com.osung.githubrepository.entity.Repository

class RepositoryDiffUtil: DiffUtil.ItemCallback<Repository>() {
    override fun areItemsTheSame(oldItem: Repository, newItem: Repository) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Repository, newItem: Repository) = oldItem == newItem
}