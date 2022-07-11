package com.example.personalaccounting.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.personalaccounting.model.dao.AddSpendDao
import com.example.personalaccounting.model.dao.DailyMovementDao
import com.example.personalaccounting.model.entity.AddSpendEntity
import com.example.personalaccounting.model.entity.DailyMovementEntity

@Database(entities = [
    DailyMovementEntity::class,
    AddSpendEntity::class]
    , version = 1, exportSchema = false)
abstract class PersonalAccountingDateBase : RoomDatabase() {

    companion object{

        //volatile to make it singletone
        @Volatile
        private var instance:PersonalAccountingDateBase ? =null
        private val LOCK=Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: createDataBase(context).also { instance=it }
        }

        private fun createDataBase(context: Context) =
            Room.databaseBuilder(context.applicationContext,PersonalAccountingDateBase::class.java,"PersonalAccountingDateBase").build()
    }

    abstract fun getAddSpendDao() : AddSpendDao
    abstract fun getDailyMovementDao() : DailyMovementDao
}