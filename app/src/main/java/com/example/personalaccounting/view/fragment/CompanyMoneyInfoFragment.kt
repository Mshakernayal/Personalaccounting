package com.example.personalaccounting.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.personalaccounting.databinding.FragmentCompanyMoneyInfoBinding


class CompanyMoneyInfoFragment : Fragment() {

    private var _binding:FragmentCompanyMoneyInfoBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompanyMoneyInfoBinding.inflate(inflater,container,false)
        return binding.root
    }

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        binding.btnCompanyMoneyInfoForwardPage.setOnClickListener {

            var action = CompanyMoneyInfoFragmentDirections.actionCompanyMoneyInfoFragmentToMainFragment()
            navController.navigate(action)
        }
    }
}