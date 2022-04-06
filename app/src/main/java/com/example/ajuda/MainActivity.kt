package com.example.ajuda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(500)
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Ajuda)
        setContentView(R.layout.activity_main)

    }
}