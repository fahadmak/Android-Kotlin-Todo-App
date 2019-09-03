package com.capsule.kotlintodo.todo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capsule.kotlintodo.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import java.util.*
import javax.inject.Inject

class TodoListActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoListFragment: TodoListFragment = TodoListFragment.getInstance()

        val fragmentManager = supportFragmentManager

        fragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, todoListFragment)
            .commit()
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}
