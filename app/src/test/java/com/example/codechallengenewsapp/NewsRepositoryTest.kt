package com.example.codechallengenewsapp


import com.example.codechallengenewsapp.data.datasource.local.LocalDataSource
import com.example.codechallengenewsapp.data.datasource.local.entity.NewsEntity
import com.example.codechallengenewsapp.data.datasource.network.RemoteDataSource
import com.example.codechallengenewsapp.data.model.News
import com.example.codechallengenewsapp.data.model.mapToNews
import com.example.codechallengenewsapp.data.repository.NewsRepositoryImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
internal class NewsRepositoryTest {

    @MockK
    lateinit var localDataSource: LocalDataSource

    @MockK
    lateinit var remoteDataSource: RemoteDataSource

    private lateinit var repositoryImpl: NewsRepositoryImpl

    private val testScope = TestScope()

    private fun mockNews() = News(
        id = 0,
        author = "Fatemeh",
        title = "title news0",
        description = "description0",
        urlToImage = "https:/img0.jpg"
    )

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        mockkStatic(NewsEntity::mapToNews)
        coEvery { any<NewsEntity>().mapToNews() } returns mockNews()
        repositoryImpl = NewsRepositoryImpl(remoteDataSource, localDataSource, testScope)
    }

    @Test
    fun `getAllNews should return flow of news list`() = testScope.runTest {
        // Given
        val expectedNewsList = NewsFake.newsList
        coEvery { localDataSource.getAllNews() } returns flow { NewsFakeEntity.list }

        // When
        val resultFlow = repositoryImpl.getAllNews()

        // Then
        coVerify { localDataSource.getAllNews() }
        resultFlow.collect { result ->
            assertEquals(expectedNewsList, result)
        }
    }

}