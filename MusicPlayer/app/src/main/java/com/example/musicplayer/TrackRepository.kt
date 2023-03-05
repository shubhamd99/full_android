package com.example.musicplayer

import com.example.musicplayer.models.Track
import com.example.musicplayer.models.toTrack
import com.example.musicplayer.util.Constants
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class TrackRepository {
    private val storage = Firebase.storage
    private val albumArt = storage.reference.child(Constants.ALBUM_ART_ALL_CAPS)
    private val trackRef = storage.reference

    suspend fun getTracks() = suspendCoroutine<List<Track>> { result ->
        val trackList = mutableListOf<Track>()

        try {
            Firebase.firestore.collection(Constants.TRACKS).get().addOnCompleteListener { task ->
                var index = 0

                task.result.forEach { document ->
                    val imageUrl = albumArt.child(document.getString(Constants.ALBUM_ART)!!)
                    val trackUrl = trackRef.child(document.getString(Constants.FILENAME)!!)

                    imageUrl.downloadUrl.addOnSuccessListener { imageDownloadUrl ->
                        trackUrl.downloadUrl.addOnSuccessListener { trackDownloadUrl ->
                            trackList.add(
                                document.toTrack(
                                    index,
                                    imageDownloadUrl.toString(),
                                    trackDownloadUrl.toString()
                                )
                            )
                            if (index == task.result.size() - 1) {
                                result.resume(trackList)
                            }
                            index++
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}