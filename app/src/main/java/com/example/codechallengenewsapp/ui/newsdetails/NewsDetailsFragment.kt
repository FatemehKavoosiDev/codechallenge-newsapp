package com.example.codechallengenewsapp.ui.newsdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.navArgs
import com.example.codechallengenewsapp.R
import com.example.codechallengenewsapp.data.model.NewsDetails
import com.example.codechallengenewsapp.databinding.NewsDetailsFragmentBinding
import com.example.codechallengenewsapp.utils.ResultState
import com.example.codechallengenewsapp.utils.launchAndCollectIn
import com.example.codechallengenewsapp.utils.loadImageFromUrl
import com.example.codechallengenewsapp.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailsFragment : Fragment() {
    private var _binding: NewsDetailsFragmentBinding? = null
    private val binding: NewsDetailsFragmentBinding
        get() = _binding!!

    private val newsDetailsViewModel: NewsDetailsViewModel by viewModels()
    private val navArg: NewsDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = NewsDetailsFragmentBinding.inflate(layoutInflater)

        newsDetailsViewModel.getNewsDetails(navArg.argNewsDetailsId)

        newsDetailsViewModel.newsDetails.launchAndCollectIn(
            this,
            Lifecycle.State.STARTED
        ) { resultState ->
            when (resultState) {
                is ResultState.Loading -> showLoading(resultState.isShow)
                is ResultState.Success -> setDetailsOnView(resultState.data)
                is ResultState.Error -> showError(resultState.errorMessage)
                is ResultState.Empty -> showEmptyNews()
            }
        }
        return binding.root
    }

    private fun setDetailsOnView(news: NewsDetails) {
        binding.newsDetailsAuthorTextView.text = news.author
        binding.newsDetailsDateTextView.text = news.publishedAt
        binding.newsDetailsTitleTextView.text = news.title
        binding.newsDetailsDescriptionTextView.text = news.description
        if (news.urlToImage != null) {
            binding.newsDetailsImageView.loadImageFromUrl(
                news.urlToImage,
                R.drawable.img_place_holder_news
            )
        }
    }

    private fun showError(errorMessage: String) {
        this.context?.showToast(errorMessage)
    }

    private fun showLoading(isShow: Boolean) {
        binding.progressBarNewsDetails.isVisible = isShow
    }

    private fun showEmptyNews() {
        this.context?.showToast(resources.getString(R.string.empty_news_details))
    }
}