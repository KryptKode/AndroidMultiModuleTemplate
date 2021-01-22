package com.kryptkode.commonandroid.view

interface ObservableAppView<ListenerType> : AppView {
    fun registerListener(listener: ListenerType)
    fun unregisterListener(listener: ListenerType)
}