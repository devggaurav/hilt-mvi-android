package com.gc.hiltandktor.repository

import com.gc.hiltandktor.model.Blog
import com.gc.hiltandktor.retrofit.BlogRetrofit
import com.gc.hiltandktor.retrofit.NetworkMapper
import com.gc.hiltandktor.room.BlogDao
import com.gc.hiltandktor.room.CacheMapper
import com.gc.hiltandktor.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

//
// Created by gc on 08/05/21.
// Copyright (c) 2021 gc. All rights reserved.
//

class MainRepository
constructor(
    private val blogDao: BlogDao,
    private val blogRetrofit: BlogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {

    suspend fun getBlog(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        kotlinx.coroutines.delay(100)
        try {
            val networkBlog = blogRetrofit.getData()
            val blogs = networkMapper.mapFromEntityList(networkBlog)
            for (blog in blogs) {
                blogDao.insert(cacheMapper.mapToEntity(blog))
            }
            val cachedBlogs = blogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }

    }


}