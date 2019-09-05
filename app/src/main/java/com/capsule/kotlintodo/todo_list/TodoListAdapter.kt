package com.capsule.kotlintodo.todo_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capsule.kotlintodo.data.models.Todo
import com.capsule.kotlintodo.databinding.TodoItemBinding

class TodoListAdapter(private val todoList: List<Todo>): RecyclerView.Adapter<TodoListAdapter.TodoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)

        val binding: TodoItemBinding = TodoItemBinding.inflate(inflater, parent, false)

        return TodoHolder(binding)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        val todo: Todo = todoList[position]
        holder.bind(todo)
    }

    class TodoHolder(private val itemBinding: TodoItemBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(todo: Todo) {
            itemBinding.todo = todo
            itemBinding.executePendingBindings()
        }
    }
}

