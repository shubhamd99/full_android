package com.example.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.example.noteapp.model.Note
import com.example.noteapp.screen.NoteScreen
import com.example.noteapp.ui.theme.NoteAppTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {

                    val notes = remember {
                        mutableStateListOf<Note>()
                    }

                    NoteScreen(
                        notes = notes,
                        onAddNote = {
                            notes.add(it)
                        },
                        onRemoveNote = {
                            notes.remove(it)
                        }
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@ExperimentalComposeUiApi
@Composable
fun DefaultPreview() {
    NoteAppTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            NoteScreen(
                notes = emptyList(),
                onAddNote = {},
                onRemoveNote = {}
            )
        }
    }
}