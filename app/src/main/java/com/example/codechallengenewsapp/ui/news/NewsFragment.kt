package com.example.codechallengenewsapp.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codechallengenewsapp.R
import com.example.codechallengenewsapp.domain.model.News
import com.example.codechallengenewsapp.databinding.NewsFragmentBinding
import com.example.codechallengenewsapp.utils.ResultState
import com.example.codechallengenewsapp.utils.launchAndCollectIn
import com.example.codechallengenewsapp.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {
    private var _binding: NewsFragmentBinding? = null
    private val binding: NewsFragmentBinding
        get() = _binding!!

    private val newsViewModel: NewsViewModel by viewModels()
    private lateinit var newsAdapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = NewsFragmentBinding.inflate(layoutInflater)

        initAdapter()

        newsViewModel.newsListFlow.launchAndCollectIn(
            this,
            Lifecycle.State.STARTED
        ) { resultState ->
            when (resultState) {
                is ResultState.Loading -> showLoading(resultState.isShow)
                is ResultState.Success -> showNews(resultState.data)
                is ResultState.Error -> showError(resultState.errorMessage)
                is ResultState.Empty -> showEmptyNews()
            }
        }

        return binding.root
    }

    private fun initAdapter() {
        binding.newsRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val onClickItemNewsAdapter: (news: News) -> Unit = { news ->
            navigateToNewsDetailsFragment(news)
        }
        newsAdapter = NewsAdapter(onClickItemNewsAdapter)
        binding.newsRecyclerView.adapter = newsAdapter
    }

    private fun navigateToNewsDetailsFragment(news: News) {
        findNavController().navigate(
            NewsFragmentDirections.actionNewsFragmentToNewsDetailsFragment(
                news.id
            )
        )
    }

    private fun showNews(news: List<News>) {
        newsAdapter.submitList(news)
    }

    private fun showError(errorMessage: String) {
        this.context?.showToast(errorMessage)
    }

    private fun showLoading(isShow: Boolean) {
        binding.progressBarNews.isVisible = isShow
    }
    private fun showEmptyNews() {
        this.context?.showToast(resources.getString(R.string.empty_news))
    }
}