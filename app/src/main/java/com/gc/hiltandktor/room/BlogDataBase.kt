package com.gc.hiltandktor.room

import androidx.room.Database
import androidx.room.RoomDatabase

//
// Created by gc on 08/05/21.
// Copyright (c) 2021 gc. All rights reserved.
//

@Database(entities = [BlogCacheEntity::class],version = 1,exportSchema = false)
abstract class BlogDataBase :RoomDatabase(){

    abstract fun blogDao() : BlogDao

    companion object{
        val DATABASE_NAME : String = "blog_gc"
    }
}