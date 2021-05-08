package com.gc.hiltandktor.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//
// Created by gc on 08/05/21.
// Copyright (c) 2021 gc. All rights reserved.
//

data class BlogNetworkEntity(

    @SerializedName("pk")
    @Expose
    var id: Int,
    @SerializedName("title")
    @Expose
    var title: String,
    @SerializedName("body")
    @Expose
    var body: String,
    @SerializedName("image")
    @Expose
    var image: String,
    @SerializedName("category")
    @Expose
    var category: String,


    ) {


}