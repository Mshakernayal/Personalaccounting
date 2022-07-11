package com.example.personalaccounting.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.personalaccounting.databinding.FragmentAddInvoiceOnCompanyBinding


class AddInvoiceOnCompanyFragment : Fragment() {

    private var _binding:FragmentAddInvoiceOnCompanyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddInvoiceOnCompanyBinding.inflate(inflater,container,false)
        return binding.root
    }

    private lateinit var navController:NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        binding.btnAddInvoiceOnCompanySave.setOnClickListener {

            var action = AddInvoiceOnCompanyFragmentDirections.actionAddInvoiceOnCompanyFragmentToDailyMovementFragment()
            navController.navigate(action)
        }
    }
}