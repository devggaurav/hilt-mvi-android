package com.gc.hiltandktor.di

import com.gc.hiltandktor.model.Blog
import com.gc.hiltandktor.repository.MainRepository
import com.gc.hiltandktor.retrofit.BlogRetrofit
import com.gc.hiltandktor.retrofit.NetworkMapper
import com.gc.hiltandktor.room.BlogDao
import com.gc.hiltandktor.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//
// Created by gc on 08/05/21.
// Copyright (c) 2021 gc. All rights reserved.
//
@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        retrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(blogDao, retrofit, cacheMapper, networkMapper)
    }
}