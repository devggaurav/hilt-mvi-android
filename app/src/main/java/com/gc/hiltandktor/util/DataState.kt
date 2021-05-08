package com.gc.hiltandktor.util

import java.lang.Exception

//
// Created by gc on 08/05/21.
// Copyright (c) 2021 gc. All rights reserved.
//

sealed class DataState<out R> {

    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()


}