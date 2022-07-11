package com.example.personalaccounting.model.dao

import androidx.room.*
import com.example.personalaccounting.model.entity.DailyMovementEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyMovementDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dailyMovementEntity: DailyMovementEntity)

    @Delete
    suspend fun delete(dailyMovementEntity: DailyMovementEntity)

    @Update
    suspend fun update(dailyMovementEntity: DailyMovementEntity)

    @Query("SELECT * From DailyMovements")
    fun getAllDailyMovement() : Flow<List<DailyMovementEntity>>
}