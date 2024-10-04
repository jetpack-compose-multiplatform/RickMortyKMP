package com.lizardoreyes.rickmortykmp.data.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

fun getDatabase(): RickMortyDatabase {
    val dbFile = "${fileDirectory()}/$DATABASE_NAME"
    return Room.databaseBuilder<RickMortyDatabase>(name = dbFile)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

@OptIn(ExperimentalForeignApi::class)
fun fileDirectory(): String {
    val documentDirectory: NSURL? = NSFileManager.defaultManager.URLsForDirectory(
        directory = NSDocumentDirectory,
        inDomains = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null
    )

    return requiredNotNull(documentDirectory).path!!
}
