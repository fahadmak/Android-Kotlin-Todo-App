package com.capsule.kotlintodo.di.subcomponents.todo_list

import com.capsule.kotlintodo.di.modules.todo_list.TodoListFragmentModule
import com.capsule.kotlintodo.todo_list.TodoListActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [TodoListFragmentModule::class])
interface TodoListActivitySubComponent: AndroidInjector<TodoListActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<TodoListActivity>

}
