package com.example.expo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity

import com.example.expo.ui.theme.ExpoTheme

class SegundaPantalla : ComponentActivity() {

    private val tiempo=1500
    private val handler=Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_carga)

        handler.postDelayed({
            val intent:Intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }, tiempo.toLong())
    }
}

