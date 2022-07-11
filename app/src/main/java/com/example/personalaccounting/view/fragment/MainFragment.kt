package com.example.personalaccounting.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.personalaccounting.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _binding:FragmentMainBinding? =null
    private val binding  get() =  _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        binding.CardViewMainDailyMovement.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToDailyMovementFragment()
            navController.navigate(action)
        }

        binding.CardViewMainTotalDays.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToDailyTotalFragment2()
            navController.navigate(action)
        }

        binding.CardViewMainPaymentsAndDept.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToPaymentAndDeptNames()
            navController.navigate(action)
        }

        binding.CardViewMainPricesTables.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToTobelPriceFragment()
            navController.navigate(action)
        }

        binding.CardViewMainWareHouse.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToWareHouseFragment()
            navController.navigate(action)
        }

        binding.CardViewMainAssignmentMaterial.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToAssignedMaterialAhadefFragment()
            navController.navigate(action)
        }
    }

}