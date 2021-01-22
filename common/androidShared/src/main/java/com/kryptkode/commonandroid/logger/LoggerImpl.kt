package com.kryptkode.commonandroid.logger

import android.os.Build
import com.kryptkode.commonandroid.BuildConfig
import java.util.regex.Pattern
import timber.log.Timber

/**
 * Created by kryptkode on 5/21/2020.
 */
class LoggerImpl : Logger {

    private val debugTreeTag = DebugTreeTag()

    init {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun d(message: String, vararg objects: Any) {
        Timber.tag(debugTreeTag.getTag())
        Timber.d(message, *objects)
    }

    override fun d(throwable: Throwable, message: String, vararg objects: Any) {
        Timber.tag(debugTreeTag.getTag())
        Timber.d(throwable, message, *objects)
    }

    override fun i(message: String, vararg objects: Any) {
        Timber.tag(debugTreeTag.getTag())
        Timber.i(message, *objects)
    }

    override fun i(throwable: Throwable, message: String, vararg objects: Any) {
        Timber.tag(debugTreeTag.getTag())
        Timber.i(throwable, message, *objects)
    }

    override fun w(message: String, vararg objects: Any) {
        Timber.tag(debugTreeTag.getTag())
        Timber.w(message, *objects)
    }

    override fun w(throwable: Throwable, message: String, vararg objects: Any) {
        Timber.tag(debugTreeTag.getTag())
        Timber.w(throwable, message, *objects)
    }

    override fun e(message: String, vararg objects: Any) {
        Timber.tag(debugTreeTag.getTag())
        Timber.e(message, *objects)
    }

    override fun e(throwable: Throwable, message: String, vararg objects: Any) {
        Timber.tag(debugTreeTag.getTag())
        Timber.e(throwable, message, *objects)
    }

    inner class DebugTreeTag {

        private val fqcnIgnore = listOf(
            Timber::class.java.name,
            Logger::class.java.name,
            LoggerImpl::class.java.name,
            DebugTreeTag::class.java.name
        )

        private val anonymousClassPattern =
            Pattern.compile("(\\$\\d+)+$")

        private fun createStackElementTag(element: StackTraceElement): String {
            var tag = element.className
            val m = anonymousClassPattern.matcher(tag)
            if (m.find()) {
                tag = m.replaceAll("")
            }
            tag = tag.substring(tag.lastIndexOf('.') + 1)
            // Tag length limit was removed in API 24.
            return if (tag.length <= LOG_TAG_MAX_LENGTH ||
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
            ) {
                tag
            } else tag.substring(0, LOG_TAG_MAX_LENGTH)
        }

        fun getTag(): String {
            return Throwable().stackTrace
                .first { it.className !in fqcnIgnore }
                .let(::createStackElementTag)
        }
    }

    companion object {
        const val LOG_TAG_MAX_LENGTH = 23
    }
}
