package com.example.codechallengenewsapp.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codechallengenewsapp.data.model.News
import com.example.codechallengenewsapp.domain.NewsUseCase
import com.example.codechallengenewsapp.utils.ResultState
import com.example.codechallengenewsapp.utils.myLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class NewsViewModel @Inject constructor(private val newsUseCase: NewsUseCase) :
    ViewModel() {
    private var mutableStateFlowNewsList =
        MutableStateFlow<ResultState<List<News>>>(ResultState.Loading(true))
    val newsListFlow = mutableStateFlowNewsList.asStateFlow()

    init {
        getNews()
    }

    private fun getNews() {
        mutableStateFlowNewsList.value = ResultState.Loading(true)
        viewModelScope.launch(Dispatchers.IO) {
            newsUseCase().catch {
                mutableStateFlowNewsList.value = ResultState.Error(it.message.toString())
            }.collect { news ->
                if (news.isEmpty())
                    mutableStateFlowNewsList.value = ResultState.Empty
                else {
                    mutableStateFlowNewsList.value = ResultState.Loading(false)
                    delay(500)
                    mutableStateFlowNewsList.value = ResultState.Success(news)
                }
            }
        }
    }


}