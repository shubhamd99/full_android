package com.example.noteapp.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.noteapp.R
import com.example.noteapp.components.NoteButton
import com.example.noteapp.components.NoteInputText
import com.example.noteapp.model.Note
import java.time.format.DateTimeFormatter

@ExperimentalComposeUiApi
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {

    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier.padding(6.dp)
    ) {
        TopAppBar(
            title = {
                    Text(text = stringResource(id = R.string.app_name))
            }, 
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "Icon"
                )
            },
            backgroundColor = Color(0xFFDADFE3)
        )

        // Content
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(
                modifier = Modifier.padding(
                    top = 9.dp,
                    bottom = 8.dp
                ),
                text = title,
                label = "Title",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) title = it
                },
                onImeAction = {}
            )
            NoteInputText(
                modifier = Modifier.padding(
                    top = 9.dp,
                    bottom = 8.dp
                ),
                text = description,
                label = "Add a note",
                onTextChange = {
                               if (it.all { char ->
                                       char.isLetter() || char.isWhitespace()
                               }) description = it
                },
                onImeAction = {}
            )
            NoteButton(
                text = "Save",
                onClick = {
                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        // Save/add to the list
                        onAddNote(Note(
                            title = title,
                            description = description,
                        ))
                        // Clear state
                        title = ""
                        description = ""
                        // Success Message
                        Toast.makeText(
                            context,
                            "Note Added",
                            Toast.LENGTH_SHORT
                        ).show()
                        keyboardController?.hide()
                    }
                }
            )
        }
        
        Divider(modifier = Modifier.padding(10.dp))
        
        LazyColumn {
            items(notes) { note ->
                NoteRow(
                    note = note,
                    onNoteClicked = {
                        onRemoveNote(it)
                    }
                )
            }
        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit
) {
    Surface(
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(color = 0xFFDFE6EB),
        elevation = 6.dp
    ) {
        Column(
            modifier = modifier
                .clickable { onNoteClicked(note) }
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.subtitle2
            )
            Text(
                text = note.description,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
                style = MaterialTheme.typography.caption
            )
        }
    }
}
