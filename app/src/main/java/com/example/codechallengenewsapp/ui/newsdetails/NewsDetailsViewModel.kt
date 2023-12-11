package com.example.codechallengenewsapp.ui.newsdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codechallengenewsapp.data.model.NewsDetails
import com.example.codechallengenewsapp.domain.NewDetailsUseCase
import com.example.codechallengenewsapp.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class NewsDetailsViewModel @Inject constructor(private val newDetailsUseCase: NewDetailsUseCase) :
    ViewModel() {
    private var mutableStateFlowNewsDetails =
        MutableStateFlow<ResultState<NewsDetails>>(ResultState.Loading(true))
    val newsDetails = mutableStateFlowNewsDetails.asStateFlow()

    fun getNewsDetails(id: Int) {
        mutableStateFlowNewsDetails.value = ResultState.Loading(true)
        viewModelScope.launch(Dispatchers.IO) {
            newDetailsUseCase(id).catch {
            }.collect { news ->
                mutableStateFlowNewsDetails.value = ResultState.Loading(false)
                delay(500)
                mutableStateFlowNewsDetails.value = ResultState.Success(news)
            }
        }
    }

}