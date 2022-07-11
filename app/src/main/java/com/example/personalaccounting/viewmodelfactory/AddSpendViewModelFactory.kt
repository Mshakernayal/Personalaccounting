package com.example.personalaccounting.viewmodelfactory

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.personalaccounting.repository.AddSpendRepository
import com.example.personalaccounting.viewmodel.AddSpendViewModel

class AddSpendViewModelFactory(private val addSpendRepository: AddSpendRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddSpendViewModel(addSpendRepository) as T
    }
}