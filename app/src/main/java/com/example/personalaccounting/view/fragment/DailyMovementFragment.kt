package com.example.personalaccounting.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.personalaccounting.R
import com.example.personalaccounting.databinding.FragmentDailyMovementBinding

class DailyMovementFragment : Fragment() {
    private var isOpen = false
    private lateinit var fabOpen : Animation; lateinit var fabClose : Animation; lateinit var rotateForward:Animation;lateinit var rotateBackward : Animation
    private var _binding:FragmentDailyMovementBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fabOpen = AnimationUtils.loadAnimation(context, R.anim.open_anim)
        fabClose = AnimationUtils.loadAnimation(context, R.anim.close_anim)
        rotateForward = AnimationUtils.loadAnimation(context, R.anim.rotate_backward_anim)
        rotateBackward  = AnimationUtils.loadAnimation(context, R.anim.rotate_farward_anim)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDailyMovementBinding.inflate(inflater,container,false)
        return binding.root
    }
    private lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        //region fab animation

        binding.fabDailyMovementAddToDay.setOnClickListener {

            animateFab()
        }

        binding.fabDailyMovementInvoice.setOnClickListener {

            binding.fabDailyMovementFromCompany.startAnimation(fabOpen)
            binding.fabDailyMovementToCompany.startAnimation(fabOpen)
            binding.fabDailyMovementSpends.startAnimation(fabClose)
            binding.fabDailyMovementFromCompany.setClickable(true)
            binding.fabDailyMovementToCompany.setClickable(true)
            binding.fabDailyMovementSpends.setClickable(false)
            binding.fabDailyMovementFromCompany.setText("من")
            binding.fabDailyMovementToCompany.setText("على")
        }

        binding.fabDailyMovementPayment.setOnClickListener {

            binding.fabDailyMovementFromCompany.startAnimation(fabOpen)
            binding.fabDailyMovementToCompany.startAnimation(fabOpen)
            binding.fabDailyMovementSpends.startAnimation(fabOpen)
            binding.fabDailyMovementFromCompany.setClickable(true)
            binding.fabDailyMovementToCompany.setClickable(true)
            binding.fabDailyMovementSpends.setClickable(true)
            binding.fabDailyMovementFromCompany.setText("الى")
            binding.fabDailyMovementToCompany.setText("من")
        }

        binding.fabDailyMovementFromCompany.setOnClickListener {

            if(binding.fabDailyMovementFromCompany.text.toString().equals("من")){

                var action = DailyMovementFragmentDirections.actionDailyMovementFragmentToAddInvoiceFromCompanyFragment()
                navController.navigate(action)
            }
            else{
                var action = DailyMovementFragmentDirections.actionDailyMovementFragmentToAddPaymentToCompanyFragment()
                navController.navigate(action)
            }

            binding.fabDailyMovementFromCompany.startAnimation(fabClose)
            binding.fabDailyMovementToCompany.startAnimation(fabClose)
            binding.fabDailyMovementSpends.startAnimation(fabClose)
            binding.fabDailyMovementFromCompany.setClickable(false)
            binding.fabDailyMovementToCompany.setClickable(false)
            binding.fabDailyMovementSpends.setClickable(false)
            animateFab()
        }

        binding.fabDailyMovementToCompany.setOnClickListener {

            if(binding.fabDailyMovementToCompany.text.toString().equals("على")){
                var action = DailyMovementFragmentDirections.actionDailyMovementFragmentToAddInvoiceOnCompanyFragment()
                navController.navigate(action)
            }
            else{
                var action = DailyMovementFragmentDirections.actionDailyMovementFragmentToAddPaymentFromCompanyFragment()
                navController.navigate(action)
            }

            binding.fabDailyMovementFromCompany.startAnimation(fabClose)
            binding.fabDailyMovementToCompany.startAnimation(fabClose)
            binding.fabDailyMovementSpends.startAnimation(fabClose)
            binding.fabDailyMovementFromCompany.setClickable(false)
            binding.fabDailyMovementToCompany.setClickable(false)
            binding.fabDailyMovementSpends.setClickable(false)
            animateFab()
        }

        binding.fabDailyMovementSpends.setOnClickListener {

            var action = DailyMovementFragmentDirections.actionDailyMovementFragmentToAddSpendFragment()
            navController.navigate(action)

            binding.fabDailyMovementFromCompany.startAnimation(fabClose)
            binding.fabDailyMovementToCompany.startAnimation(fabClose)
            binding.fabDailyMovementSpends.startAnimation(fabClose)
            binding.fabDailyMovementFromCompany.setClickable(false)
            binding.fabDailyMovementToCompany.setClickable(false)
            binding.fabDailyMovementSpends.setClickable(false)
            animateFab()
        }

        //endregion

    }

    private fun animateFab(){
        if (isOpen){
            binding.fabDailyMovementAddToDay.startAnimation(rotateForward)
            binding.fabDailyMovementInvoice.startAnimation(fabClose)
            binding.fabDailyMovementPayment.startAnimation(fabClose)
            binding.fabDailyMovementInvoice.setClickable(false)
            binding.fabDailyMovementPayment.setClickable(false)
            isOpen=false;
        }
        else {
            binding.fabDailyMovementAddToDay.startAnimation(rotateBackward)
            binding.fabDailyMovementInvoice.startAnimation(fabOpen)
            binding.fabDailyMovementPayment.startAnimation(fabOpen)
            binding.fabDailyMovementInvoice.setClickable(true)
            binding.fabDailyMovementPayment.setClickable(true)
            isOpen=true
        }
    }
}