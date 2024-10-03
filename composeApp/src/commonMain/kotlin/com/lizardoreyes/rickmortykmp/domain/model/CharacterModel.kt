package com.lizardoreyes.rickmortykmp.domain.model

import kotlinx.serialization.SerialName

data class CharacterModel(
    val id: Int,
    val name: String,
    val isAlive: Boolean,
    val species: String,
    val type: String,
    val image: String
)
