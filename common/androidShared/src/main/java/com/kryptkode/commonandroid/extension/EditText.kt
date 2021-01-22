package com.kryptkode.commonandroid.extension

import android.text.InputFilter
import android.widget.EditText

fun EditText.setAllCapsInputFilter() {
    val existingFilters = filters
    val newFilters = existingFilters.copyOf(existingFilters.size + 1)
    newFilters[existingFilters.size] = InputFilter.AllCaps()
    filters = newFilters
}
