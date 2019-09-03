package com.capsule.kotlintodo.di.subcomponents.todo_list

import com.capsule.kotlintodo.todo_list.TodoListFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface TodoListFragmentSubComponent: AndroidInjector<TodoListFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<TodoListFragment>
}
