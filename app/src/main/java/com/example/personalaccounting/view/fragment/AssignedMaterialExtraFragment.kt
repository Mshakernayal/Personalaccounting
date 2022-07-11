package com.example.personalaccounting.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.personalaccounting.databinding.FragmentAssignedMaterialExtraBinding

class AssignedMaterialExtraFragment : Fragment() {

    private var _binding:FragmentAssignedMaterialExtraBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAssignedMaterialExtraBinding.inflate(inflater,container,false)
        return binding.root
    }

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        var args= AssignedMaterialExtraFragmentArgs.fromBundle(requireArguments())
        binding.txtAssignedMaterialExtraTotalMeterPrice.text= args.khamMeterPrice.toString()

        binding.edtAssignedMaterialExtraAlmasbahaPrice.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var almasbahaPrice= s.toString().toFloat()
                var totalMeterPrice= binding.txtAssignedMaterialExtraTotalMeterPrice.text.toString().toFloat()
                binding.txtAssignedMaterialExtraTotalMeterPrice.text= "${totalMeterPrice + almasbahaPrice}"
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.edtAssignedMaterialExtraAlmatbaPrice.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var almatbaPrice= s.toString().toFloat()
                var totalMeterPrice= binding.txtAssignedMaterialExtraTotalMeterPrice.text.toString().toFloat()
                binding.txtAssignedMaterialExtraTotalMeterPrice.text= "${totalMeterPrice + almatbaPrice}"
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.edtAssignedMaterialExtraAlsakalPrice.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var alsakalPrice= s.toString().toFloat()
                var totalMeterPrice= binding.txtAssignedMaterialExtraTotalMeterPrice.text.toString().toFloat()
                binding.txtAssignedMaterialExtraTotalMeterPrice.text= "${totalMeterPrice + alsakalPrice}"
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.edtAssignedMaterialExtraSpends.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var spends= s.toString().toFloat()
                var totalMeterPrice= binding.txtAssignedMaterialExtraTotalMeterPrice.text.toString().toFloat()
                binding.txtAssignedMaterialExtraTotalMeterPrice.text= "${totalMeterPrice + spends}"
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.fabAssignedMaterialExtraForwardPage.setOnClickListener {

            var action = AssignedMaterialExtraFragmentDirections.actionAssignedMaterialExtraFragmentToMainFragment()
            navController.navigate(action)
        }
    }
}