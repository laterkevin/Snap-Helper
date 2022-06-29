package com.example.a25c_liveapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // hier das zu ladende Layout File ändern um andere Screens am Device zu laden
        setContentView(R.layout.login_screen)
    }
}
