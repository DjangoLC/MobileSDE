package com.example.itijuanatest.ui.driverdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.itijuanatest.R
import com.example.itijuanatest.databinding.FragmentDriverDetailBinding
import com.example.itijuanatest.ui.driverslist.DriversViewModel
import com.example.itijuanatest.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DriverDetailFragment : BaseFragment<FragmentDriverDetailBinding>() {

    private val shipmentsViewModel: ShipmentsViewModel by viewModels()
    private val args: DriverDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shipmentsViewModel.getDriver(args.driverId)
        observe()
    }

    private fun observe() {
        shipmentsViewModel.uiState.observe(viewLifecycleOwner) { state ->
            when(state) {
                is ShipmentListState.Error -> TODO()
                ShipmentListState.Loading -> TODO()
                is ShipmentListState.Success -> {
                    binding.tvDriverName.text = state.data.driver.name
                    binding.tvShipmentName.text = state.data.shipment.addressName
                }
            }
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentDriverDetailBinding {
        return FragmentDriverDetailBinding.inflate(inflater, parent, false)
    }
}