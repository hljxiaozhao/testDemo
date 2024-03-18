package com.seanutf.bookmanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.seanutf.bookmanagement.entities.Book
import com.seanutf.bookmanagement.ui.theme.BookManagementTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookManagementTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BookManagementScreen()
                }
            }
        }
    }
}

@Composable
fun BookList(books: List<BookEntity>, onBookSelect: (BookEntity) -> Unit) {
    LazyColumn {
        items(books){
            Text(
                text = "${it.title} : ${it.author}",
                modifier = Modifier.padding(16.dp).clickable {
                    onBookSelect(it)
                })
        }
    }
}

@Composable
fun BookDetails(book: BookEntity){
    Column (modifier = Modifier.padding(16.dp)){
        Text(text = "Title:${book.title}")
        Text(text = "Author:${book.author}")
    }
}

@Composable
fun BookManagementScreen(){
    var books : List<BookEntity> by remember {
        bookDao.getAllBooks()
    }
    var selectedBook : List<BookEntity> by remember {
        mutableStateOf(books.firstOrNull())
    }
    Column {
        Button(onClick = {
            bookDao.insertBook(BookEntity("new Book","new Author"))
        }) {
            Text(text = "add a new book")   
        }
        
        BookList(books = books) {
            selectedBook = it
        }
        selectedBook?.let { BookDetails(book = it) }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBookManagementScreen() {
    BookManagementTheme {
        BookManagementScreen()
    }
}