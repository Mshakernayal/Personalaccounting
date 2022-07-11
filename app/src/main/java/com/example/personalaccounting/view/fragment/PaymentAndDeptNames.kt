package com.example.personalaccounting.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.example.personalaccounting.databinding.FragmentPaymentAndDeptNamesBinding


class PaymentAndDeptNames : Fragment() {

    private var _binding:FragmentPaymentAndDeptNamesBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaymentAndDeptNamesBinding.inflate(inflater,container,false)
        return binding.root
    }

    private lateinit var navController:NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // from adapter will navigate
    }
}