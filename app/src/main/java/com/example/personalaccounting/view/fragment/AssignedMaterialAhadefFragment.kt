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
import com.example.personalaccounting.databinding.FragmentAssignedMaterialAhadefBinding


class AssignedMaterialAhadefFragment : Fragment() {

    private var _binding:FragmentAssignedMaterialAhadefBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAssignedMaterialAhadefBinding.inflate(inflater,container,false)
        return binding.root
    }

    private lateinit var navController:NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        binding.edtAssignedMaterialAlhadefNumretAlkhet.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val alsaheb= s.toString().toFloat()
                if(s.toString().toInt() >40){
                    binding.txtAssignedMaterialAlhadefAlsahebText.text="${alsaheb/8700}"
                }
                else{
                    binding.txtAssignedMaterialAlhadefAlsahebText.text="${alsaheb/1.65}"
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.edtAssignedMaterialAlhadefAlmusht.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var weight= s.toString().toFloat() * binding.edtAssignedMaterialAlhadefArdAlkemash.text.toString().toFloat() / binding.txtAssignedMaterialAlhadefAlsahebText.text.toString().toFloat()
                binding.txtAssignedMaterialAlhadefWeightText.text="${weight}"
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.edtAssignedMaterialAlhadefAlmusht.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var weight= s.toString().toFloat() * binding.edtAssignedMaterialAlhadefArdAlkemash.text.toString().toFloat() / binding.txtAssignedMaterialAlhadefAlsahebText.text.toString().toFloat()
                binding.txtAssignedMaterialAlhadefWeightText.text="${weight}"
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.edtAssignedMaterialAlhadefAlkhetPrice.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var alkhetPrice= s.toString().toFloat() * binding.txtAssignedMaterialAlhadefWeightText.text.toString().toFloat()
                binding.txtAssignedMaterialAlhadefAlhadefPriceText.text= "${alkhetPrice}"
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.edtAssignedMaterialAlhadefAlsenPrice.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var alsenPrice= s.toString().toFloat() * binding.txtAssignedMaterialAlhadefAlhadefPriceText.text.toString().toFloat()
                binding.txtAssignedMaterialAlhadefAlmusanaaPriceText.text= "${alsenPrice}"
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.fabAssignedMaterialAlhadefForwardPage.setOnClickListener {

            val alhadefPrice = binding.txtAssignedMaterialAlhadefAlhadefPriceText.text.toString().toFloat()
            var action = AssignedMaterialAhadefFragmentDirections.actionAssignedMaterialAhadefFragmentToAssignedMaterialAlsedahFragment(alhadefPrice)
            navController.navigate(action)
        }
    }
}