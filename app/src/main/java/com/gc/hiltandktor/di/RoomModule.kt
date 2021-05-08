package com.gc.hiltandktor.di

import android.content.Context
import androidx.room.Room
import com.gc.hiltandktor.room.BlogDao
import com.gc.hiltandktor.room.BlogDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//
// Created by gc on 08/05/21.
// Copyright (c) 2021 gc. All rights reserved.
//

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideBlogDB(@ApplicationContext context: Context): BlogDataBase {
        return Room.databaseBuilder(context, BlogDataBase::class.java, BlogDataBase.DATABASE_NAME)
            .fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideBlogDao(blogDataBase: BlogDataBase): BlogDao {
        return blogDataBase.blogDao()
    }


}