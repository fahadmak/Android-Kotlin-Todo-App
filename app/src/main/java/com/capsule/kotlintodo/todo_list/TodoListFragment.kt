package com.capsule.kotlintodo.todo_list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capsule.kotlintodo.R
import com.capsule.kotlintodo.data.models.Todo
import com.capsule.kotlintodo.todo_list.TodoListContract.Presenter
import com.capsule.kotlintodo.todo_list.TodoListContract.TodoView
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class TodoListFragment:Fragment(), TodoView {

    lateinit var progressBar: ProgressBar

    lateinit var recyclerView: RecyclerView

    @Inject lateinit var todoListPresenter: TodoListPresenter

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

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        progressBar = view.findViewById<ProgressBar>(R.id.progress_bar)
        recyclerView.layoutManager = LinearLayoutManager(context)
        todoListPresenter.fetchTodoList()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun displayTodoList(todoList: List<Todo>) {
        recyclerView.visibility = View.VISIBLE

        recyclerView.adapter = TodoListAdapter(todoList)
    }

}
