package com.kryptkode.commonandroid.livedata.event

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
data class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Consumes the content if it's not been consumed yet and run the block [block].
     */
    fun consumeAndRun(block: (T?) -> Unit) {
        if (!hasBeenHandled) {
            block(getContentIfNotHandled())
        }
    }

    fun consumeAndRunNonNull(block: (T) -> Unit) {
        consumeAndRun { if (it != null) block(it) }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content
}
