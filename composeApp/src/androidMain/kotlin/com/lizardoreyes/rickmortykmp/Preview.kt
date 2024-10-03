package com.lizardoreyes.rickmortykmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel
import com.lizardoreyes.rickmortykmp.ui.home.tabs.characters.CharacterOfTheDay

@Preview
@Composable
fun Preview() {
    CharacterOfTheDay(CharacterModel(
        id = 1,
        name = "Rick",
        isAlive = true,
        species = "Human",
        type = "Scientist",
        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
    ))
}