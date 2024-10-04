package com.lizardoreyes.rickmortykmp.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.lizardoreyes.rickmortykmp.data.database.dao.UserPreferencesDAO
import com.lizardoreyes.rickmortykmp.data.database.entity.CharacterOfTheDayEntity

const val DATABASE_NAME = "rickmorty.db"

expect object RickMortyCTor: RoomDatabaseConstructor<RickMortyDatabase>

@Database(entities = [CharacterOfTheDayEntity::class], version = 1)
@ConstructedBy(RickMortyCTor::class)
abstract class RickMortyDatabase: RoomDatabase() {

    abstract fun getPreferencesDao(): UserPreferencesDAO
}