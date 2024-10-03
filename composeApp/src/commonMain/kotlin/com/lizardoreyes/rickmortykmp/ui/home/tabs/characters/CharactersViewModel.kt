package com.lizardoreyes.rickmortykmp.ui.home.tabs.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lizardoreyes.rickmortykmp.domain.GetRandomCharacterCaseUse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersViewModel(val getRandomCharacterCaseUse: GetRandomCharacterCaseUse): ViewModel() {
    private val _state = MutableStateFlow<CharacterState>(CharacterState())
    val state: StateFlow<CharacterState> = _state

    init {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getRandomCharacterCaseUse()
            }

            _state.update { it.copy(characterOfTheDay = result) }
        }
    }
}