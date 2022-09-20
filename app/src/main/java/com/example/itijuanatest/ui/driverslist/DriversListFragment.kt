package com.example.itijuanatest.ui.driverslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itijuanatest.databinding.FragmentDriversListBinding
import com.example.itijuanatest.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DriversListFragment : BaseFragment<FragmentDriversListBinding>() {

    private val driversViewModel: DriversViewModel by viewModels()
    private val driverAdapter: DriversAdapter by lazy {
        DriversAdapter()
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): FragmentDriversListBinding {
        return FragmentDriversListBinding.inflate(inflater, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvDrivers.apply {
            adapter = driverAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
        observeData()
        driversViewModel.getAllDrivers()
    }

    private fun observeData() {
        driversViewModel._uiState.observe(viewLifecycleOwner) {
            when(it) {
                is DriversListState.Error -> {

                }
                DriversListState.Loading -> {

                }
                is DriversListState.Success -> {
                    driverAdapter.drivers = it.data
                }
            }
        }
    }

}