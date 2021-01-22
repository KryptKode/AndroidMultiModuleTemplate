package com.kryptkode.commonandroid.extension

/** Throws an [IllegalStateException] with the passed message. */
fun illegal(errorMessage: String? = null): Nothing = throw IllegalStateException(errorMessage)

/** Throws an [UnsupportedOperationException] with the passed message. */
fun unsupported(errorMessage: String? = null): Nothing =
    throw UnsupportedOperationException(errorMessage)
