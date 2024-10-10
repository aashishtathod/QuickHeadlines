package com.aashishtathod.dev.quickheadlines.ui.topHeadlines

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aashishtathod.dev.quickheadlines.databinding.ItemNewsBinding
import com.aashishtathod.dev.quickheadlines.domain.model.NewsModel

class TopHeadlinesAdapter : ListAdapter<NewsModel, TopHeadlinesAdapter.NewsItemViewHolder>(DIFF_UTIL) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return NewsItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class NewsItemViewHolder(
         private val binding: ItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            // todo set ItemCLick Listener
        }

        fun bind(news: NewsModel) {
            binding.newsTitle.text = news.title
        }

    }

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<NewsModel>() {
            override fun areItemsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
                return oldItem == newItem
            }

        }
    }
}