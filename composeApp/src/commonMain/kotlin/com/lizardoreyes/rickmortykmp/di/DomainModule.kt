package com.lizardoreyes.rickmortykmp.di

import com.lizardoreyes.rickmortykmp.domain.GetRandomCharacterCaseUse
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

var domainModule = module {
    factoryOf(::GetRandomCharacterCaseUse)
}