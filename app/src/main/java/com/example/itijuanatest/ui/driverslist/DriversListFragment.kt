package com.example.itijuanatest.ui.driverslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.itijuanatest.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DriversListFragment : Fragment(R.layout.fragment_drivers_list) {

    private val driversViewModel: DriversViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        driversViewModel.getAllDrivers()
    }

}