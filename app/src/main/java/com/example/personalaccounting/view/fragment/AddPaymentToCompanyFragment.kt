package com.example.personalaccounting.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.personalaccounting.databinding.FragmentAddPaymentToCompanyBinding


class AddPaymentToCompanyFragment : Fragment() {

    private var _binding:FragmentAddPaymentToCompanyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddPaymentToCompanyBinding.inflate(inflater,container,false)
        return binding.root
    }

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        binding.btnAddPaymentToCompanySave.setOnClickListener {

            var action = AddPaymentToCompanyFragmentDirections.actionAddPaymentToCompanyFragmentToDailyMovementFragment()
            navController.navigate(action)
        }
    }
}