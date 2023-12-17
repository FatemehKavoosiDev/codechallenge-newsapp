package com.example.codechallengenewsapp.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.codechallengenewsapp.R
import com.example.codechallengenewsapp.domain.model.News
import com.example.codechallengenewsapp.databinding.ItemNewsAdapterBinding
import com.example.codechallengenewsapp.utils.loadImageFromUrl

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
            news.apply {
                //show position and id temporarily to test
                binding.newsTitleTextView.text = "pos:$adapterPosition -id:${id} -${title}"
                binding.newsDescriptionTextView.text = news.description

                binding.root.setOnClickListener { onclickItem(news) }

                if (urlToImage != null) {
                    binding.newsImageView.loadImageFromUrl(
                        urlToImage,
                        R.drawable.img_place_holder_news
                    )
                }
            }


        }
    }

    class NewsDiffCallback : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            //Due to the null id in some news,I considered the title to be unique :)
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem == newItem
        }
    }
}