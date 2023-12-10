package com.example.codechallengenewsapp.ui.news

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codechallengenewsapp.data.model.News
import com.example.codechallengenewsapp.data.repository.NewsRepository
import com.example.codechallengenewsapp.domain.NewsUseCase
import com.example.codechallengenewsapp.utils.ResultState
import com.example.codechallengenewsapp.utils.myLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class NewsViewModel @Inject constructor(private val newsUseCase: NewsUseCase) :
    ViewModel() {
    private var mutableStateFlowNewsList =
        MutableSharedFlow<ResultState<List<News>>>(replay = 5)
    val newsListFlow = mutableStateFlowNewsList.asSharedFlow()

    init {
        getNews()
    }

    private fun getNews() {
        mutableStateFlowNewsList.tryEmit(ResultState.Loading(true))
        viewModelScope.launch(Dispatchers.IO) {
            newsUseCase().catch {
                myLog("collect in viewmodel catch")
            }.collect { news ->
                myLog("collect in viewmodel data ${news.size}")
                mutableStateFlowNewsList.emit(ResultState.Success(news))
                mutableStateFlowNewsList.emit(ResultState.Loading(false))

            }
        }
    }


}