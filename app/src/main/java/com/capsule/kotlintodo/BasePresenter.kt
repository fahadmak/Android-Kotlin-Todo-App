package com.capsule.kotlintodo

interface BasePresenter<T:View> {
    fun attachView(view:T)
}
