package com.gc.hiltandktor.ui

import androidx.lifecycle.*
import com.gc.hiltandktor.model.Blog
import com.gc.hiltandktor.repository.MainRepository
import com.gc.hiltandktor.util.DataState
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

//
// Created by gc on 08/05/21.
// Copyright (c) 2021 gc. All rights reserved.
//
@HiltViewModel
class MainViewModel
@Inject constructor(
    private val mainRepository: MainRepository,
     private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Blog>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Blog>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when (mainStateEvent) {

                is MainStateEvent.GetBlogEvents -> {
                    mainRepository.getBlog().onEach { dataState ->
                        _dataState.value = dataState
                    }.launchIn(viewModelScope)
                }
                is MainStateEvent.None -> {

                }
            }
        }
    }

}

sealed class MainStateEvent {

    object GetBlogEvents : MainStateEvent()

    object None : MainStateEvent()
}