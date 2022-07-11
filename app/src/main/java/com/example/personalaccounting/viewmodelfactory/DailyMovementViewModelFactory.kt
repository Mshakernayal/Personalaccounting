package com.example.personalaccounting.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.personalaccounting.repository.DailyMovementRepository
import com.example.personalaccounting.viewmodel.DailyMovementViewModel

class DailyMovementViewModelFactory(var dailyMovementRepository: DailyMovementRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DailyMovementViewModel(dailyMovementRepository) as T
    }
}