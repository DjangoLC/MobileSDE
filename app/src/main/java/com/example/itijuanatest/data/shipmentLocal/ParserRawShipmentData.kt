package com.example.itijuanatest.data.shipmentLocal

import android.content.Context
import com.example.itijuanatest.R
import com.example.itijuanatest.core.domain.models.Shipment
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class ParserRawShipmentData @Inject constructor(@ActivityContext private val context: Context) {
    fun getRawShipmentData(): RawShipment? {
        val str = context.resources.openRawResource(R.raw.drivers_source).bufferedReader()
            .use { it.readText() }
        return Gson().fromJson(str, RawShipment::class.java)
    }
}