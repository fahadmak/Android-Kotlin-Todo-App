package com.capsule.kotlintodo.todo_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capsule.kotlintodo.R
import com.capsule.kotlintodo.data.models.Todo
import kotlinx.android.synthetic.main.todo_item.view.*

class TodoListAdapter(private val todoList: List<Todo>): RecyclerView.Adapter<TodoListAdapter.TodoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)

        val view: View = inflater.inflate(R.layout.todo_item, parent, false)

        return TodoHolder(view)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        val todo: Todo = todoList.get(position)
        holder.itemView.checkBox.text = todo.title
        holder.itemView.checkBox.isChecked = todo.completed
    }

    class TodoHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}

