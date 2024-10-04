package com.lizardoreyes.rickmortykmp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel
import com.lizardoreyes.rickmortykmp.domain.model.CharacterOfTheDayModel

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
    val selectedDay: String
) {
    fun toDomain(): CharacterOfTheDayModel {
        return CharacterOfTheDayModel(
            characterModel = CharacterModel(
                id = id,
                name = name,
                isAlive = isAlive,
                species = species,
                type = type,
                image = image
            ),
            selectedDay = selectedDay
        )
    }
}