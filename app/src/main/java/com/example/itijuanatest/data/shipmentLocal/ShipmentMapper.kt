package com.example.itijuanatest.data.shipmentLocal

import com.example.itijuanatest.core.domain.models.Shipment
import java.util.*

fun RawShipment.toDomain() =
    this.shipments.map {
        Shipment(id = UUID.randomUUID().toString(), it)
    }
