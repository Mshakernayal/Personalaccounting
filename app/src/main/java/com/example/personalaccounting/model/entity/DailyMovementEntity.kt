package com.example.personalaccounting.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DailyMovements")
data class DailyMovementEntity(
    @ColumnInfo(name = "Details")
    var details : String,
    @ColumnInfo(name = "TotalMoney")
    var totalMoney : Int,
    @ColumnInfo(name = "Notice")
    var notice : String
){
    @PrimaryKey(autoGenerate = true)
    var id : Int ?= null
}