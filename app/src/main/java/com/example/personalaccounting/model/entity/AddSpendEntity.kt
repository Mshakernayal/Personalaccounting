package com.example.personalaccounting.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Spends")
data class AddSpendEntity(
    @ColumnInfo(name = "TotalMoney")
    var totalMoney : String,
    @ColumnInfo(name = "Notice")
    var notice : String,
    @ColumnInfo(name = "Date")
    var date : String
){
    @PrimaryKey(autoGenerate = true)
    var id : Int ?= null
}