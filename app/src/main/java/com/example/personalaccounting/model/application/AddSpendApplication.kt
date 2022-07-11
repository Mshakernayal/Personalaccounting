package com.example.personalaccounting.model.application

import android.app.Application
import com.example.personalaccounting.model.database.PersonalAccountingDateBase
import com.example.personalaccounting.repository.AddSpendRepository
import com.example.personalaccounting.viewmodelfactory.AddSpendViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class AddSpendApplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@AddSpendApplication))
        bind() from singleton { PersonalAccountingDateBase(instance()) }
        bind() from singleton { AddSpendRepository(instance()) }
        bind() from provider { AddSpendViewModelFactory(instance()) }
    }
}