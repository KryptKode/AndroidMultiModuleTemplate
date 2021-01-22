package com.kryptkode.core.cache.converter

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object StringListConverter {

    private val stringListType = Types.newParameterizedType(List::class.java, String::class.java)
    private val moshi = Moshi.Builder().build()
    private val stringListAdapter: JsonAdapter<List<String>> = moshi.adapter(stringListType)

    @TypeConverter
    @JvmStatic
    fun toStringList(text: String): List<String> {
        return stringListAdapter.fromJson(text) ?: listOf()
    }

    @TypeConverter
    @JvmStatic
    fun toText(list: List<String>): String {
        return stringListAdapter.toJson(list)
    }
}
