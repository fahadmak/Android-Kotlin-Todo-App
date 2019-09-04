package com.capsule.kotlintodo.data.remote

import com.capsule.kotlintodo.data.models.Todo
import io.reactivex.Single
import retrofit2.http.GET

interface NetworkApiService {

    @GET("todos")
    fun fetchTodo():Single<List<Todo>>

}