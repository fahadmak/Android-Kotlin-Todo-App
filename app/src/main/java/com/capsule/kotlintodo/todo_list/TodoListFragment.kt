package com.capsule.kotlintodo.todo_list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.capsule.kotlintodo.R
import com.capsule.kotlintodo.models.Todo
import com.capsule.kotlintodo.todo_list.TodoListContract.Presenter
import com.capsule.kotlintodo.todo_list.TodoListContract.TodoView
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_todo_list.view.*

class TodoListFragment:Fragment(), TodoView {

    lateinit var progressBar: ProgressBar

    var todoListPresenter: Presenter = TodoListPresenter()

    companion object {
        fun getInstance(): TodoListFragment {
            return TodoListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_todo_list, container, false)
        todoListPresenter.attachView(this)
        return rootView
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById<ProgressBar>(R.id.progress_bar)
        todoListPresenter.fetchTodoList()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun displayTodoList(todoList: List<Todo>) {
    }

}
