package com.lizardoreyes.rickmortykmp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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
    val selectedDate: String
)