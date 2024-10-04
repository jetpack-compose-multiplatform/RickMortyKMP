package com.lizardoreyes.rickmortykmp.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.lizardoreyes.rickmortykmp.data.database.entity.CharacterOfTheDayEntity

@Dao
interface UserPreferencesDAO {

    @Query("SELECT * FROM characteroftheday")
    suspend fun getCharacterOfTheDayDatabase(): CharacterOfTheDayEntity?
}