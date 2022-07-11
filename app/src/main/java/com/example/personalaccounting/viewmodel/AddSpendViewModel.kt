package com.example.personalaccounting.viewmodel

import androidx.lifecycle.*
import com.example.personalaccounting.model.entity.AddSpendEntity
import com.example.personalaccounting.repository.AddSpendRepository
import kotlinx.coroutines.launch

class AddSpendViewModel(private var addSpendRepository: AddSpendRepository) : ViewModel() {

    fun insert(addSpendEntity: AddSpendEntity) = viewModelScope.launch {
        addSpendRepository.insert(addSpendEntity)
    }

    fun delete(addSpendEntity: AddSpendEntity) = viewModelScope.launch {
        addSpendRepository.delete(addSpendEntity)
    }

    fun update(addSpendEntity: AddSpendEntity) = viewModelScope.launch {
        addSpendRepository.update(addSpendEntity)
    }

    val allSpend = addSpendRepository.getAllSpend().asLiveData()
}