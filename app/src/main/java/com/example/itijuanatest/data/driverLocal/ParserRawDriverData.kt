package com.example.itijuanatest.data.driverLocal

import android.content.Context
import com.example.itijuanatest.R
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class ParserRawDriverData @Inject constructor(@ActivityContext private val context: Context) {
    fun getRawDriverData(): RawDriver? {
        val str = context.resources.openRawResource(R.raw.drivers_source).bufferedReader()
            .use { it.readText() }
        return Gson().fromJson(str, RawDriver::class.java)
    }
}