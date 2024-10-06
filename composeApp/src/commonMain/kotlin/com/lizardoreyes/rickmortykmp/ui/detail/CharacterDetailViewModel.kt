package com.lizardoreyes.rickmortykmp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lizardoreyes.rickmortykmp.domain.Repository
import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterDetailViewModel(characterModel: CharacterModel, val repository: Repository): ViewModel() {

    private val _uiState = MutableStateFlow<CharacterDetailState>(CharacterDetailState(characterModel))
    val uiState: StateFlow<CharacterDetailState> = _uiState

    init {
        getEpisodesForCharacter(characterModel.episode)
    }

    private fun getEpisodesForCharacter(episode: List<String>) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                repository.getEpisodesForCharacter(episode)
            }

            _uiState.update { it.copy(episodes = result) }
        }
    }
}