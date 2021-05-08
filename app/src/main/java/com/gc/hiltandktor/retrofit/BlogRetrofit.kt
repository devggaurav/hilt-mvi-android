package com.gc.hiltandktor.retrofit

import retrofit2.http.GET

//
// Created by gc on 08/05/21.
// Copyright (c) 2021 gc. All rights reserved.
//

interface BlogRetrofit {

    @GET("blogs")
    suspend fun getData(): List<BlogNetworkEntity>
}