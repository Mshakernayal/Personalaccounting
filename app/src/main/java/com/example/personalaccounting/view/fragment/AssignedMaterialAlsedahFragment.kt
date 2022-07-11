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
import com.example.personalaccounting.databinding.FragmentAssignedMaterialAlsedahBinding


class AssignedMaterialAlsedahFragment : Fragment() {

    private var _binding:FragmentAssignedMaterialAlsedahBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAssignedMaterialAlsedahBinding.inflate(inflater,container,false)
        return binding.root
    }

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        binding.edtAssignedMaterialAlsedaNumretAkhet.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var alsaheb= s.toString().toFloat()
                if(s.toString().toInt() >40){
                    binding.txtAssignedMaterialAlsedahAlsahebText.text="${alsaheb/8700}"
                }
                else{
                    binding.txtAssignedMaterialAlsedahAlsahebText.text="${alsaheb*1.65}"
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.edtAssignedMaterialAlsedafAlmusht.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var almusht= s.toString().toFloat() * binding.edtAssignedMaterialAlsedahArdAlkemash.text.toString().toFloat() / binding.txtAssignedMaterialAlsedahAlsahebText.text.toString().toFloat()
                binding.txtAssignedMaterialAlsadahWeightText.text="${almusht}"
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.edtAssignedMaterialAlsedaAlkhetPrice.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var alkhetPrice=s.toString().toFloat() * binding.txtAssignedMaterialAlsadahWeightText.text.toString().toFloat()
                var args= AssignedMaterialAlsedahFragmentArgs.fromBundle(requireArguments())
                binding.txtAssignedMaterialAlsadahAlsadahPriceText.text="${alkhetPrice}"
                binding.txtAssignedMaterialAlsadahKhamMeterPriceText.text="${args.alhadefPrice + alkhetPrice}"
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.fabAssignedMaterialAlsedaForwardPage.setOnClickListener {

            var khamMeterPrice= binding.txtAssignedMaterialAlsadahKhamMeterPriceText.text.toString().toFloat()
            var action = AssignedMaterialAlsedahFragmentDirections.actionAssignedMaterialAlsedahFragmentToAssignedMaterialExtraFragment(khamMeterPrice)
            navController.navigate(action)
        }
    }
}