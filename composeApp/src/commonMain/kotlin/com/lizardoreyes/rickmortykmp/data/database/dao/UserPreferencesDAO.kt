package com.lizardoreyes.rickmortykmp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lizardoreyes.rickmortykmp.data.database.entity.CharacterOfTheDayEntity

@Dao
interface UserPreferencesDAO {

    @Query("SELECT * FROM characteroftheday")
    suspend fun getCharacterOfTheDayDatabase(): CharacterOfTheDayEntity?

    @Insert(entity = CharacterOfTheDayEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacterOfTheDayDatabase(characterOfTheDayEntity: CharacterOfTheDayEntity)
}