package com.osung.githubrepository.view.adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.osung.githubrepository.databinding.ItemSearchRepositoryBinding
import com.osung.githubrepository.entity.Repository

class SearchAdapter: PagingDataAdapter<Repository, SearchAdapter.SearchViewHolder>(RepositoryDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SearchViewHolder(ItemSearchRepositoryBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class SearchViewHolder(
        private val binding: ItemSearchRepositoryBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(repositoryItem: Repository) {
            binding.repositoryItem = repositoryItem
        }
    }
}