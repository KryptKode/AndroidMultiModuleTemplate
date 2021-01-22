package com.kryptkode.core.cache.converter

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateConverter {

    @JvmStatic
    val formatter = SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH)

    @TypeConverter
    @JvmStatic
    fun toDate(text: String): Date = formatter.parse(text)!!

    @TypeConverter
    @JvmStatic
    fun toText(date: Date): String = formatter.format(date)
}
