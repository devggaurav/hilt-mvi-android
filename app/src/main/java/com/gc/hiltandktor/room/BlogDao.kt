package com.gc.hiltandktor.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//
// Created by gc on 08/05/21.
// Copyright (c) 2021 gc. All rights reserved.
//

@Dao
interface BlogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(blogCacheEntity: BlogCacheEntity): Long


    @Query("SELECT * FROM blogs")
    suspend fun get(): List<BlogCacheEntity>


}