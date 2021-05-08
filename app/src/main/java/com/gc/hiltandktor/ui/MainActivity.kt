package com.gc.hiltandktor.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.gc.hiltandktor.R
import com.gc.hiltandktor.model.Blog
import com.gc.hiltandktor.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG: String = "AppDebug"

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribeObserver()
        viewModel.setStateEvent(MainStateEvent.GetBlogEvents)

    }

    private fun subscribeObserver() {
        viewModel.dataState.observe(this, Observer {
            when (it) {
                is DataState.Success<List<Blog>> -> {
                    var data = ""
                    if (it != null) {
                        var data = StringBuilder()
                        for (blog in it.data) {
                            data.append(blog.title + "\n")
                        }
                        displayError(data.toString())
                    }


                }
                is DataState.Error -> {

                }
                is DataState.Loading -> {

                }


            }


        })
    }

    private fun displayError(message: String?) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
    }
}