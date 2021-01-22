package com.kryptkode.commonandroid.livedata.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import com.kryptkode.commonandroid.livedata.event.Event
import com.kryptkode.commonandroid.livedata.event.EventObserver

typealias MutableLiveEvent<T> = MutableLiveData<Event<T>>

typealias LiveEvent<T> = LiveData<Event<T>>

/**
 * Create an event with the provided [value] and set the value of this [MutableLiveEvent]
 */
fun <T> MutableLiveEvent<T>.publish(value: T) {
    this.value = Event(value)
}

fun <T> MutableLiveData<T>.asLiveData(): LiveData<T> = this

fun <T> LiveData<T>.observe(owner: LifecycleOwner, observer: (T) -> Unit) =
    observe(owner, Observer { observer.invoke(it) })

fun <T> LiveData<Event<T>>.observeEvent(owner: LifecycleOwner, observer: (T) -> Unit) =
    observe(
        owner,
        EventObserver<T> {
            observer.invoke(it)
        }
    )

infix fun <X, Y> LiveData<X>.switchMap(func: (X) -> LiveData<Y>) =
    Transformations.switchMap(this, func)

infix fun <X, Y> LiveData<X>.map(func: (X) -> LiveData<Y>) = Transformations.map(this, func)

infix fun <X, Y> LiveData<X>.mapFunc(func: (X) -> Y) = Transformations.map(this, func)
