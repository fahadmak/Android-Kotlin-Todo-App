package com.capsule.kotlintodo.todo_list

import com.capsule.kotlintodo.View
import com.capsule.kotlintodo.todo_list.TodoListContract.Presenter
import com.capsule.kotlintodo.todo_list.TodoListContract.TodoView

class TodoListPresenter:  Presenter {

    lateinit var todoView: TodoView

    override fun attachView(view: TodoView) {
        this.todoView = view
    }

    override fun fetchTodoList() {

    }
}