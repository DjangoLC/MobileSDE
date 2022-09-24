package com.example.itijuanatest.data.shipmentLocal

import com.example.itijuanatest.core.domain.models.Shipment as ShipmentDomain
import com.example.itijuanatest.data.db.Shipment as ShipmentDb

fun RawShipment.toDomain() =
    this.shipments.map {
        ShipmentDomain(0, it)
    }

fun ShipmentDomain.toDb() = ShipmentDb(addressName = this.addressName, driverId = 0)

fun ShipmentDb.toDb() = ShipmentDomain(id = this.id, addressName = this.addressName)
