package com.example.personalaccounting.model.dao

import androidx.room.*
import com.example.personalaccounting.model.entity.AddSpendEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AddSpendDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(addSpendEntity: AddSpendEntity)

    @Delete
    suspend fun delete(addSpendEntity: AddSpendEntity)

    @Update
    suspend fun update(addSpendEntity: AddSpendEntity)

    @Query("SELECT * From Spends")
    fun getAllSpend() : Flow<List<AddSpendEntity>>
}