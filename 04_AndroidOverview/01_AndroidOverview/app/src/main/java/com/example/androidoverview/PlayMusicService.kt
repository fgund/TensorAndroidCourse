package com.example.androidoverview

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class PlayMusicService : Service() {

    private var mediaPlayer = MediaPlayer()

    override fun onBind(intent: Intent): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.something)
        showToast("PlayMusicService is created.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showToast("PlayMusicService is started...")
        // Repeating after end.
        mediaPlayer.setOnCompletionListener {
            showToast("Song ended, repeating...")
            mediaPlayer.seekTo(0)
            mediaPlayer.start()
        }
        mediaPlayer.start()
        return START_STICKY
    }

    override fun onDestroy() {
        mediaPlayer.release()
        super.onDestroy()
        showToast("PlayMusicService is destroyed!")
    }

    private fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}