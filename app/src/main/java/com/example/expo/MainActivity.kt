package com.example.expo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var Loginboton: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Loginboton = findViewById(R.id.btnLogin)

        Loginboton.setOnClickListener {
            var login: Intent = Intent(this, login::class.java)
            startActivity(login)
        }
    }
}