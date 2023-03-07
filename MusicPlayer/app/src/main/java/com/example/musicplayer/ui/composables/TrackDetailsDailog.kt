package com.example.musicplayer.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.musicplayer.R
import com.example.musicplayer.models.Track
import com.example.musicplayer.ui.theme.dialogColor

@Composable
fun TrackDetailDailog(
    track: MutableState<Track?>,
    openDialog: MutableState<Boolean>
) {
    if (openDialog.value && track.value != null) {
        val track = track.value!!
        AlertDialog(
            backgroundColor = dialogColor,
            title = {
                    Text(text = track.songTitle)
            },
            text = {
                   Column {
                       Text(text = stringResource(id = R.string.artist) + " " + track.artist)
                       Text(text = stringResource(id = R.string.trackNo) + " " + (track.index + 1))                   }
            },
            buttons = {
                      Row(
                          modifier = Modifier.padding(8.dp),
                          horizontalArrangement = Arrangement.Center
                      ) {
                          Button(
                              modifier = Modifier
                                  .padding(12.dp)
                                  .fillMaxWidth(),
                              onClick = { openDialog.value = false }
                          ) {
                              Text(text = stringResource(id = R.string.dismiss))
                          }
                      }
            },
            onDismissRequest = { openDialog.value = false }
        )
    }
}