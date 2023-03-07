package com.example.musicplayer

import android.util.Log
import com.example.musicplayer.models.Track
import com.example.musicplayer.models.toTrack
import com.example.musicplayer.util.Constants
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import com.google.firebase.storage.ktx.storage
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class TrackRepository {
    private val storage = Firebase.storage(Firebase.app)
    private val albumArtRef = storage.reference.child(Constants.ALBUM_ART_ALL_CAPS)
    private val trackReference = storage.reference

    suspend fun getTracks() = suspendCoroutine<List<Track>> {
        val albumList = mutableListOf<Track>()

        try {
            Firebase.firestore.collection(Constants.TRACKS)
                .get().addOnCompleteListener { task ->
                    var index = 0

                    task.result.forEach { document ->
                        val imageUrl = albumArtRef.child(document.getString(Constants.ALBUM_ART)!!)
                        val trackUrl = trackReference.child(document.getString(Constants.FILENAME)!!)

                        imageUrl.downloadUrl.addOnSuccessListener { imageDownloadUrl ->
                            trackUrl.downloadUrl.addOnSuccessListener { trackDownloadUrl ->
                                albumList.add(
                                    document.toTrack(
                                        index,
                                        imageDownloadUrl.toString(),
                                        trackDownloadUrl.toString()
                                    )
                                )
                                if (index == task.result.size() - 1) {
                                    it.resume(albumList)
                                }
                                index++
                            }
                        }
                    }
                }
        } catch (e: Exception) {
            Log.d("trackSync", "failed : ${e.message}")
        }
    }
}