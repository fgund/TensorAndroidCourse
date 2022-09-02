package com.example.androidanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            addStartFragment()
        }
    }

    private fun addStartFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, StartFragment())
            .commit()
    }
}