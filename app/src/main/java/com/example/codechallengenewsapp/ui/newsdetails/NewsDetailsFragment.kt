package com.example.codechallengenewsapp.ui.newsdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.codechallengenewsapp.databinding.NewsDetailsFragmentBinding
import com.example.codechallengenewsapp.utils.myLog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailsFragment : Fragment() {
    private var _binding: NewsDetailsFragmentBinding? = null
    private val binding: NewsDetailsFragmentBinding
        get() = _binding!!

    private val newsDetailsViewModel: NewsDetailsViewModel by viewModels()
    private val navArg :NewsDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = NewsDetailsFragmentBinding.inflate(layoutInflater)

        newsDetailsViewModel.getNewsDetails(navArg.argNewsDetailsId)

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        myLog("onDestroyView newsdetailsFragment")
    }
    override fun onDestroy() {
        super.onDestroy()
        myLog("onDestroy newsdetailsFragment")

    }
}