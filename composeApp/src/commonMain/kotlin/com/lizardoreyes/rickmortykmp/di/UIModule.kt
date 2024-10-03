package com.lizardoreyes.rickmortykmp.di

import com.lizardoreyes.rickmortykmp.ui.home.tabs.characters.CharactersViewModel
import com.lizardoreyes.rickmortykmp.ui.home.tabs.episodes.EpisodesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

var uiModule = module {
    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharactersViewModel)
}