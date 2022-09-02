package com.example.androidoverview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

class MusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        val serviceIntent = Intent(this,PlayMusicService::class.java)

        val stopButton = findViewById<Button>(R.id.stop_music_button)
        stopButton.setOnClickListener {
            stopButton.setTextColor(ContextCompat.getColor(this, R.color.teal_200))
            stopService(serviceIntent)
        }

        startService(serviceIntent)
    }
}