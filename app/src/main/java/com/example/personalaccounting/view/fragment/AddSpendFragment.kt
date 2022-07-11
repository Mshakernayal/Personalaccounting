package com.example.personalaccounting.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.personalaccounting.databinding.FragmentAddSpendBinding
import com.example.personalaccounting.model.entity.AddSpendEntity
import com.example.personalaccounting.viewmodel.AddSpendViewModel
import com.example.personalaccounting.viewmodelfactory.AddSpendViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class AddSpendFragment : Fragment(), KodeinAware {

    private var _binding:FragmentAddSpendBinding? = null
    private val binding get() = _binding!!
    private var isAdding = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddSpendBinding.inflate(inflater,container,false)
        return binding.root
    }

    private lateinit var navController:NavController

    override val kodein by kodein()
    private val factory : AddSpendViewModelFactory by instance()
    private lateinit var addSpendViewModel : AddSpendViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addSpendViewModel = ViewModelProvider(requireActivity(),factory)[AddSpendViewModel::class.java]

        navController = findNavController()

        binding.btnAddSpendSave.setOnClickListener {
            if(isAdding)
            {
                insert()
                navController.navigate(AddSpendFragmentDirections.actionAddSpendFragmentToDailyMovementFragment())
            }
            else
            {
                update()
                navController.navigate(AddSpendFragmentDirections.actionAddSpendFragmentToDailyMovementFragment())
            }
        }

        binding.btnAddSpendCancel.setOnClickListener {
            if(isAdding)
            {
                navController.navigate(AddSpendFragmentDirections.actionAddSpendFragmentToDailyMovementFragment())
            }
            else
            {
                delete()
                navController.navigate(AddSpendFragmentDirections.actionAddSpendFragmentToDailyMovementFragment())
            }
        }
    }

    private fun insert()
    {
        val totalMoney = binding.edtAddSpendSpendMoney.text.toString()
        val notice = binding.edtAddSpendNotice.text.toString()
        val date = binding.txtAddSpendDateText.text.toString()
        val addSpendEntity = AddSpendEntity(totalMoney,notice,date)
        addSpendViewModel.insert(addSpendEntity)
    }

    private fun delete()
    {
        //current entity
    }

    private fun update()
    {
        //current entity
    }
}
