package com.example.codechallengenewsapp

import com.example.codechallengenewsapp.domain.NewsUseCase
import com.example.codechallengenewsapp.ui.news.NewsViewModel
import com.example.codechallengenewsapp.utils.ResultState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class NewsViewModelTest {

    private val scheduler = TestCoroutineScheduler()
    private val dispatcher = UnconfinedTestDispatcher(scheduler)

    @MockK
    private lateinit var newsUseCase: NewsUseCase

    // @InjectMockKs
    private lateinit var viewModel: NewsViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun `when collect contain emit list of news, the newsState is equal ResultState-Success`() = runTest {
        // Given
        val newsListFake = NewsFake.newsList
        coEvery { newsUseCase() } returns flowOf(newsListFake)
        viewModel = NewsViewModel(newsUseCase, dispatcher)

        // When
        newsUseCase().collect()

        // Then
        coVerify { newsUseCase() }
        assertEquals(ResultState.Loading(false), viewModel.newsListFlow.value)
        delay(500)
        assertEquals(ResultState.Success(newsListFake), viewModel.newsListFlow.value)
    }
    @Test
    fun `when collect to news is empty,the newsState is equal ResultState-Empty`() = runTest {
        // Given
        coEvery { newsUseCase() } returns flowOf(emptyList())
        viewModel = NewsViewModel(newsUseCase, dispatcher)

        // When
        newsUseCase().collect()

        // Then
        coVerify { newsUseCase() }
        assertEquals(ResultState.Empty, viewModel.newsListFlow.value)
    }

}