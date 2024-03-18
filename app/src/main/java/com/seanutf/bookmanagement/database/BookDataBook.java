package com.seanutf.bookmanagement.database;

import androidx.room.Database;

@Database(entities = [BookEntity::class],version = 1)
abstract class BookDataBook :RoomDataBase(){
    abstract fun bookDao():BookDao
}
