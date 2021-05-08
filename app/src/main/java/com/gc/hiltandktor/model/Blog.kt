package com.gc.hiltandktor.model

//
// Created by gc on 08/05/21.
// Copyright (c) 2021 gc. All rights reserved.
//

data class Blog(
    var id: Int,
    var title: String,
    var body: String,
    var image: String,
    var category: String
) {
}