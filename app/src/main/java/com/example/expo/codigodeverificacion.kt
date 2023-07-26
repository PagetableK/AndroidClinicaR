package com.example.expo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

lateinit var Codigo: EditText
lateinit var Botonsiguiente: Button

class codigodeverificacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codigodeverificacion)

        Codigo = findViewById(R.id.txtCodigo)
        Botonsiguiente = findViewById(R.id.btnSiguiente)

        val codigo: String = intent.getStringExtra("0")!!
        val destinatario: String = intent.getStringExtra("1")!!

        val EnviarCodigo =EnviarCorreo(destinatario, codigo)
        EnviarCodigo.execute()

        Botonsiguiente.setOnClickListener {

            if(Codigo.text.toString() == codigo)
            {
                val Cambiar: Intent = Intent(this, CambiarContra::class.java)
                Cambiar.putExtra("correo", destinatario)
                startActivity(Cambiar)
            }
            else
            {
                Toast.makeText(this, "El código es incorrecto", Toast.LENGTH_SHORT).show()
            }

        }

    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}