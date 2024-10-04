package com.lizardoreyes.rickmortykmp.di

import com.lizardoreyes.rickmortykmp.data.database.RickMortyDatabase
import com.lizardoreyes.rickmortykmp.data.database.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single<RickMortyDatabase> { getDatabase(get()) }
    }
}