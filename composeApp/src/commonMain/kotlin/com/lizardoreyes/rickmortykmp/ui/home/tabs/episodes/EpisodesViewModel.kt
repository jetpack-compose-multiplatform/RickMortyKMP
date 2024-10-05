package com.lizardoreyes.rickmortykmp.ui.home.tabs.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.lizardoreyes.rickmortykmp.domain.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class EpisodesViewModel(private val repository: Repository): ViewModel() {

    private val _state = MutableStateFlow(EpisodesState())
    val state: StateFlow<EpisodesState> = _state

    init {
        _state.update { it.copy(characters = repository.getAllEpisodes().cachedIn(viewModelScope)) }
    }

    fun onPlaySelected(url: String) {
        _state.update {
            it.copy(playVideo = url)
        }
    }

    fun onCloseVideo() {
        _state.update {
            it.copy(playVideo = "")
        }
    }
}