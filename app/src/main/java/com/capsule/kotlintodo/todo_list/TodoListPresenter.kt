package com.capsule.kotlintodo.todo_list

import com.capsule.kotlintodo.data.models.Todo
import com.capsule.kotlintodo.data.remote.NetworkApiService
import com.capsule.kotlintodo.todo_list.TodoListContract.Presenter
import com.capsule.kotlintodo.todo_list.TodoListContract.TodoView
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TodoListPresenter @Inject constructor(private var apiService: NetworkApiService) : Presenter {

    lateinit var todoView: TodoView

    lateinit var disposable: Disposable

    override fun attachView(view: TodoView) {
        this.todoView = view
    }

    override fun fetchTodoList() {
        disposable = apiService.fetchTodo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { todoList: List<Todo> ->
                todoView.hideLoading()
                todoView.displayTodoList(todoList)
            }
    }
}
