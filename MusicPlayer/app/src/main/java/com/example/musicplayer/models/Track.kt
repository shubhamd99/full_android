package com.example.musicplayer.models

import com.example.musicplayer.util.Constants
import com.google.firebase.firestore.QueryDocumentSnapshot

data class Track(
    val img : String,
    val index : Int,
    val songTitle : String,
    val artist : String,
    val trackUrl : String,
    var isPlaying : Boolean,
    var fileName : String
)

fun QueryDocumentSnapshot.toTrack(index: Int, imgUrl: String, trackUrl: String) : Track {
    return Track(
        img = imgUrl,
        songTitle = this.getString(Constants.NAME) ?: "",
        artist = this.getString(Constants.ARTIST) ?: "",
        fileName = this.getString(Constants.FILENAME) ?: "",
        isPlaying = false,
        index = index,
        trackUrl = trackUrl
    )
}