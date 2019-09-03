package com.capsule.kotlintodo.todo_list

import com.capsule.kotlintodo.BasePresenter
import com.capsule.kotlintodo.View
import com.capsule.kotlintodo.models.Todo

interface TodoListContract {

    interface TodoView : View {
        fun showLoading()
        fun hideLoading()
        fun displayTodoList(todoList: List<Todo>)
    }

    interface Presenter : BasePresenter<TodoView> {
        fun fetchTodoList()
    }
}