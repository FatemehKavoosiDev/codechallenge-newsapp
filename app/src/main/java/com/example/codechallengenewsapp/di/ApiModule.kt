package com.example.codechallengenewsapp.di

import com.example.codechallengenewsapp.data.datasource.network.NewsApiService
import com.example.codechallengenewsapp.utils.Const
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class ApiModule {
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class LoginInterceptor

    @Singleton
    @LoginInterceptor
    @Provides
    fun provideInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @LoginInterceptor loginInterceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(loginInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()
                )
            )
            .baseUrl(Const.BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsApiService(retrofit: Retrofit) = retrofit.create(NewsApiService::class.java)

}