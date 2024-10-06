package com.lizardoreyes.rickmortykmp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel
import com.lizardoreyes.rickmortykmp.domain.model.CharacterOfTheDayModel
import kotlinx.serialization.json.Json

@Entity(tableName = "characteroftheday")
data class CharacterOfTheDayEntity (
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "isAlive")
    val isAlive: Boolean,

    @ColumnInfo(name = "species")
    val species: String,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "selectedDate")
    val selectedDay: String,

    @ColumnInfo(name = "origin")
    val origin: String,

    @ColumnInfo(name = "gender")
    val gender: String,

    @ColumnInfo(name = "episodes")
    val episode: String,
) {
    fun toDomain(): CharacterOfTheDayModel {
        return CharacterOfTheDayModel(
            characterModel = CharacterModel(
                id = id,
                name = name,
                isAlive = isAlive,
                species = species,
                type = type,
                image = image,
                gender = gender,
                origin = origin,
                episode = Json.decodeFromString<List<String>>(episode)
            ),
            selectedDay = selectedDay
        )
    }
}