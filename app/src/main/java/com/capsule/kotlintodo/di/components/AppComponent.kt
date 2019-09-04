package com.capsule.kotlintodo.di.components

import com.capsule.kotlintodo.app.BaseApplication
import com.capsule.kotlintodo.di.modules.AppModule
import com.capsule.kotlintodo.di.modules.todo_list.TodoListActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    AndroidSupportInjectionModule::class,
    AppModule::class,
    TodoListActivityModule::class])
interface AppComponent: AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: BaseApplication): Builder

        fun build(): AppComponent
    }
}
