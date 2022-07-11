package com.example.personalaccounting.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.personalaccounting.model.entity.DailyMovementEntity
import com.example.personalaccounting.repository.DailyMovementRepository
import kotlinx.coroutines.launch

class DailyMovementViewModel(var dailyMovementRepository: DailyMovementRepository) : ViewModel() {

    fun insert(dailyMovementEntity: DailyMovementEntity) = viewModelScope.launch {
        dailyMovementRepository.insert(dailyMovementEntity)
    }

    fun delete(dailyMovementEntity: DailyMovementEntity) = viewModelScope.launch {
        dailyMovementRepository.delete(dailyMovementEntity)
    }

    fun update(dailyMovementEntity: DailyMovementEntity) = viewModelScope.launch {
        dailyMovementRepository.update(dailyMovementEntity)
    }

    fun getAllDailyMovement() = dailyMovementRepository.getAllDailyMovement().asLiveData()
}