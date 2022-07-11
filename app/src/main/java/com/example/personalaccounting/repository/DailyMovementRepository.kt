package com.example.personalaccounting.repository

import com.example.personalaccounting.model.database.PersonalAccountingDateBase
import com.example.personalaccounting.model.entity.DailyMovementEntity
import kotlinx.coroutines.flow.Flow

class DailyMovementRepository(var dataBase : PersonalAccountingDateBase){

    suspend fun insert(dailyMovementEntity: DailyMovementEntity)
    {
        dataBase.getDailyMovementDao().insert(dailyMovementEntity)
    }

    suspend fun delete(dailyMovementEntity: DailyMovementEntity)
    {
        dataBase.getDailyMovementDao().delete(dailyMovementEntity)
    }

    suspend fun update(dailyMovementEntity: DailyMovementEntity)
    {
        dataBase.getDailyMovementDao().update(dailyMovementEntity)
    }

    fun getAllDailyMovement() : Flow<List<DailyMovementEntity>> = dataBase.getDailyMovementDao().getAllDailyMovement()
}