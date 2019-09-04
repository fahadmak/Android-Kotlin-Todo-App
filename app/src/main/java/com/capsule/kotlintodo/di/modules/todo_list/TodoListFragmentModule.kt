package com.capsule.kotlintodo.di.modules.todo_list

import com.capsule.kotlintodo.di.subcomponents.todo_list.TodoListFragmentSubComponent
import com.capsule.kotlintodo.todo_list.TodoListFragment
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.Binds
import dagger.Module


@Module(subcomponents = [TodoListFragmentSubComponent::class])
abstract class TodoListFragmentModule {

    @Binds
    @IntoMap
    @ClassKey(TodoListFragment::class)
    internal abstract fun
            bindYourFragmentInjectorFactory(factory: TodoListFragmentSubComponent.Factory)
            : AndroidInjector.Factory<*>

}
