package com.example.itijuanatest.ui.driverdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.itijuanatest.R
import com.example.itijuanatest.ui.driverslist.DriversViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DriverDetailFragment : Fragment(R.layout.fragment_driver_detail) {

    private val shipmentsViewModel: ShipmentsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shipmentsViewModel.getAllShipments()
    }
}