package com.capsule.kotlintodo.di.components

import com.capsule.kotlintodo.app.BaseApplication
import com.capsule.kotlintodo.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [
    AppModule::class,
    AndroidSupportInjectionModule::class,
    AppModule::class])
interface AppComponent: AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: BaseApplication): Builder

        fun build(): AppComponent
    }
}
