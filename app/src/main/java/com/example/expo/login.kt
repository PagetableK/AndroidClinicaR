package com.example.expo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.sql.SQLException
import java.sql.PreparedStatement


lateinit var RecuperarTexto: TextView
lateinit var PacienteEmail: EditText
lateinit var PacienteContra: EditText
lateinit var PacienteLogin:Button

class login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        private var connectSql = Conexion()

        RecuperarTexto = findViewById(R.id.txtRecuperar)

        RecuperarTexto.setOnClickListener {

            val Enviar: Intent = Intent(this, RecuperaciondeCuenta::class.java)
            startActivity(Enviar)

        }

        PacienteEmail=findViewById(R.id.txtEmailPacientes)
        PacienteContra=findViewById(R.id.passPacientes)
        PacienteLogin=findViewById(R.id.btnIngresar)

        PacienteLogin.setOnClickListener{



            try {

                val Email= PacienteEmail.text.toString()
                val Contraseña= PacienteContra.text.toString()

                val statement =connectSql.dbConn()?.createStatement()
                var RS=statement?.executeQuery("select correo from tbPacientes")
                var RS2=statement?.executeQuery("select contraseña from tbPacientes")


                if (RS.next()==Email && RS2=Contraseña){

                }
                else{

                }
            }catch (ex: SQLException){
                Toast.makeText(this, "Error al mostrar", Toast.LENGTH_SHORT).show()
            }

    }
}