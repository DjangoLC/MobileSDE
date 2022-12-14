package com.example.itijuanatest.ui.driverslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.itijuanatest.core.domain.models.Driver
import com.example.itijuanatest.databinding.DriverLayoutBinding
import kotlin.properties.Delegates

typealias onClickDriver = (Driver) -> Unit

class DriversAdapter(private val onClickDriver: onClickDriver) :
    RecyclerView.Adapter<DriversViewHolder>() {

    var drivers: List<Driver> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriversViewHolder {
        return DriversViewHolder.fromViewHolder(parent)
    }

    override fun onBindViewHolder(holder: DriversViewHolder, position: Int) {
        holder.bind(drivers[position], onClickDriver)
    }

    override fun getItemCount(): Int {
        return drivers.size
    }
}

class DriversViewHolder(private val binding: DriverLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(driver: Driver, onClickDriver: onClickDriver) {
        binding.tvName.text = driver.name
        binding.root.setOnClickListener {
            onClickDriver.invoke(driver)
        }
    }

    companion object {
        fun fromViewHolder(parent: ViewGroup): DriversViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return DriversViewHolder(DriverLayoutBinding.inflate(inflater, parent, false))
        }
    }
}