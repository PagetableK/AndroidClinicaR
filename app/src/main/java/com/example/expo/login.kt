package com.example.expo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

lateinit var RecuperarTexto: TextView

class login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        RecuperarTexto = findViewById(R.id.txtRecuperar)

        RecuperarTexto.setOnClickListener {

            val Enviar: Intent = Intent(this, RecuperaciondeCuenta::class.java)
            startActivity(Enviar)

        }

    }
}