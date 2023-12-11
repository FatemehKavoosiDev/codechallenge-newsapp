package com.example.codechallengenewsapp.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.codechallengenewsapp.data.model.News
import com.example.codechallengenewsapp.databinding.ItemNewsAdapterBinding

internal class NewsAdapter(private val onclickItem: (news: News) -> Unit) :
    ListAdapter<News, NewsAdapter.NewsViewHolder>(NewsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsAdapterBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

    inner class NewsViewHolder(private val binding: ItemNewsAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(news: News) {
            "pos:$adapterPosition -id:${news.id} -${news.title}".also { binding.newsTitleTextView.text = it }
            binding.newsDescriptionTextView.text = news.description
            binding.root.setOnClickListener { onclickItem(news) }
        }
    }

    class NewsDiffCallback : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem == newItem
        }
    }
}