package com.capsule.kotlintodo.di.modules.todo_list

import com.capsule.kotlintodo.data.remote.NetworkApiService
import com.capsule.kotlintodo.todo_list.TodoListContract
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.capsule.kotlintodo.todo_list.TodoListContract.Presenter
import com.capsule.kotlintodo.todo_list.TodoListPresenter

@Module
class TodoListPresenterModule {

    @Provides
    @Singleton
    fun provideTodoListPresenter(apiService: NetworkApiService): TodoListPresenter {
        return TodoListPresenter(apiService)
    }

}