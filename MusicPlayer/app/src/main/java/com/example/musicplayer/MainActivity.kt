package com.example.musicplayer

import android.content.res.Configuration
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.musicplayer.models.MusicPlayerOption
import com.example.musicplayer.models.Track
import com.example.musicplayer.ui.composables.*
import com.example.musicplayer.ui.theme.MusicPlayerComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity(), OnMusicButtonClick {

    private val isPlaying = mutableStateOf(false) // is music current being played
    private var trackList = listOf<Track>() // retrieve song list
    private lateinit var currentSong: MutableState<Track>// currently playing song
    private val clickedSong: MutableState<Track?> = mutableStateOf(null)// currently playing song
    private val currentSongIndex = mutableStateOf(-1) // used for recyclerview playing overlay
    private val turntableArmState = mutableStateOf(false)// turns turntable arm
    private val isBuffering = mutableStateOf(false)
    private val isTurntableArmFinished =
        mutableStateOf(false) // lets us know the turntable Arm rotation is finished
    private lateinit var listState: LazyListState // current state of album list
    private lateinit var coroutineScope: CoroutineScope // scope to be used in composables
    private lateinit var mediaPlayer: MediaPlayer
    private val tracksViewModel: TrackViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
        setContent {
            MusicPlayerComposeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    listState = rememberLazyListState()
                    coroutineScope = rememberCoroutineScope()
                    val openDialog = remember {
                        mutableStateOf(false)
                    }
                    val trackList by tracksViewModel.trackList.observeAsState()
                    if (trackList?.isNotEmpty() == true) {
                        MainContent(
                            isPlaying = isPlaying,
                            currentSong,
                            listState,
                            onMusicPlayerClick = this@MainActivity,
                            currentSongIndex,
                            turntableArmState,
                            isTurntableArmFinished,
                            isBuffering = isBuffering,
                            trackList!!
                        ) { song ->
                            clickedSong.value = song
                            openDialog.value = true
                        }
                        TrackDetailDailog(track = clickedSong, openDialog = openDialog)
                    } else {
                        LoadingScreen()
                    }
                }
            }
        }
    }

    private fun observeViewModel() {
        tracksViewModel.trackList.observe(this) { list ->
            if (list.isNotEmpty()) {
                trackList = list
                currentSong = mutableStateOf(list.first())
            }
        }
    }

    override fun onResume() {
        super.onResume()
        when (this.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_NO -> {
                window.statusBarColor = resources.getColor(R.color.white, null)
            }
            else -> {
                window.statusBarColor = resources.getColor(R.color.black, null)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::mediaPlayer.isInitialized && isPlaying.value) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }

    override fun onMusicButtonClick(command: MusicPlayerOption) {
        when(command) {
            MusicPlayerOption.Play -> {
                currentSong.value.isPlaying = !isPlaying.value
                currentSongIndex.value = currentSong.value.index
                try {
                    if (this::mediaPlayer.isInitialized && isPlaying.value) {
                        mediaPlayer.stop()
                        mediaPlayer.release()
                        isPlaying.value = false
                    } else play()
                } catch (e: Exception) {
                    e.printStackTrace()
                    mediaPlayer.release()
                    isPlaying.value = false
                }
            }
            MusicPlayerOption.Skip -> {
                var nextSongIndex = currentSong.value.index + 1

                if (currentSong.value.index == trackList.size - 1) {
                    nextSongIndex = 0
                    if (isPlaying.value) {
                        currentSongIndex.value = 0
                    } else {
                        currentSongIndex.value++
                    }
                }

                currentSong.value = trackList[nextSongIndex]
                if (isPlaying.value) {
                    play()
                }
                updateList()
            }
            MusicPlayerOption.Previous -> {
                var prevSongIndex = currentSong.value.index - 1

                if (currentSong.value.index == 0) {
                    prevSongIndex = trackList.lastIndex
                    if (isPlaying.value) {
                        currentSongIndex.value = trackList.lastIndex
                    } else {
                        currentSongIndex.value--
                    }
                }

                currentSong.value = trackList[prevSongIndex]
                if (isPlaying.value) {
                    play()
                }
                updateList()
            }
        }
    }

    private fun updateList() {
        coroutineScope.launch {
            if (isPlaying.value) {
                currentSong.value.isPlaying = true
            }
            listState.animateScrollToItem(
                currentSong.value.index
            )
        }
    }

    private fun play() {
        try {
            if (this::mediaPlayer.isInitialized && isPlaying.value) {
                mediaPlayer.stop()
                mediaPlayer.release()
                isPlaying.value = false
                turntableArmState.value = false
                isTurntableArmFinished.value = false
            }
            isBuffering.value = true
            mediaPlayer = MediaPlayer()
            mediaPlayer.setDataSource(currentSong.value.trackUrl)
            mediaPlayer.prepareAsync()
            mediaPlayer.setOnPreparedListener {
                isBuffering.value = false
                isPlaying.value = true
                if (!turntableArmState.value) {
                    turntableArmState.value = true
                }
                mediaPlayer.start()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //UI
    @Composable
    fun MainContent(
        isPlaying: MutableState<Boolean>,
        album: MutableState<Track>,
        listState: LazyListState,
        onMusicPlayerClick: OnMusicButtonClick,
        currentSongIndex: MutableState<Int>,
        turntableArmState: MutableState<Boolean>,
        isTurntableArmFinished: MutableState<Boolean>,
        isBuffering: MutableState<Boolean>,
        albums: List<Track>,
        onTrackItemClick: (Track) -> Unit,
    ) {
        Column {
            Title()
            TrackList(
                isPlaying,
                listState,
                currentSongIndex,
                R.drawable.ic_baseline_pause_24,
                albums,
                onTrackItemClick
            )
            TurnTable(isPlaying, turntableArmState, isTurntableArmFinished)
            Player(
                album, isPlaying,
                onMusicPlayerClick = onMusicPlayerClick,
                isTurntableArmFinished = isTurntableArmFinished,
                isBuffering = isBuffering
            )
        }
    }
}

interface OnMusicButtonClick{
    fun onMusicButtonClick(command: MusicPlayerOption)
}