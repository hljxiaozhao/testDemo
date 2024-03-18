package com.seanutf.bookmanagement.database

import androidx.room.Entity
import androidx.room.Query

@Entity(tableName = "books")
data class BookEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val author:String
)

@Dao
interface BookDao{
    @Query("SELECT * FROM books")
    fun getAllBooks():List<BookEntity>

    @Insert
    fun insertBook(book: BookEntity)

    @Update
    fun updateBook(book: BookEntity)

    @Delete
    fun deleteBook(book: BookEntity)
}