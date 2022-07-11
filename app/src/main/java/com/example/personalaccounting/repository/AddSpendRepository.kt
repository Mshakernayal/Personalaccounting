package com.example.personalaccounting.repository

import androidx.room.Database
import com.example.personalaccounting.model.database.PersonalAccountingDateBase
import com.example.personalaccounting.model.entity.AddSpendEntity
import kotlinx.coroutines.flow.Flow

class AddSpendRepository(private var database: PersonalAccountingDateBase) {

    suspend fun insert(addSpendEntity: AddSpendEntity){
        database.getAddSpendDao().insert(addSpendEntity)
    }

    suspend fun delete(addSpendEntity: AddSpendEntity){
        database.getAddSpendDao().delete(addSpendEntity)
    }

    suspend fun update(addSpendEntity: AddSpendEntity){
        database.getAddSpendDao().update(addSpendEntity)
    }

    fun getAllSpend() : Flow<List<AddSpendEntity>> = database.getAddSpendDao().getAllSpend()
}