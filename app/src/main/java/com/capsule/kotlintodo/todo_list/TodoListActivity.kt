package com.capsule.kotlintodo.todo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capsule.kotlintodo.R

class TodoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoListFragment: TodoListFragment = TodoListFragment.getInstance()

        val fragmentManager = supportFragmentManager

        fragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, todoListFragment)
            .commit()
    }
}
