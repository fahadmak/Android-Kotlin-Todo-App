package com.capsule.kotlintodo.di.modules.todo_list

import com.capsule.kotlintodo.di.subcomponents.todo_list.TodoListActivitySubComponent
import com.capsule.kotlintodo.todo_list.TodoListActivity
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.android.AndroidInjector

@Module(subcomponents = [TodoListActivitySubComponent::class])
abstract class TodoListActivityModule {
    @Binds
    @IntoMap
    @ClassKey(TodoListActivity::class)
    internal abstract fun bindYourAndroidInjectorFactory(factory: TodoListActivitySubComponent.Factory):
            AndroidInjector.Factory<*>
}

