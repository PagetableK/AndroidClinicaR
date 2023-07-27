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

        var connectSql = Conexion()

        RecuperarTexto = findViewById(R.id.txtRecuperar)

        RecuperarTexto.setOnClickListener {

            val Enviar: Intent = Intent(this, RecuperaciondeCuenta::class.java)
            startActivity(Enviar)

        }

        PacienteEmail=findViewById(R.id.txtEmailPacientes)
        PacienteContra=findViewById(R.id.passPacientes)
        PacienteLogin=findViewById(R.id.btnIngresar)

        val Email= PacienteEmail.text.toString()
        val Contraseña= PacienteContra.text.toString()

        PacienteLogin.setOnClickListener{

            if(PacienteEmail.text.toString().trim() == "" || PacienteContra.text.toString().trim() == "")
            {
                Toast.makeText(this, "Datos faltantes, Asegúrese de llenar todos los datos", Toast.LENGTH_SHORT).show()
            }
            else {
                try {
                    val statement = connectSql.dbConn()?.createStatement()
                    var RS =
                        statement?.executeQuery("select idpaciente, nombre, correo, contraseña from tbPacientes where correo='${Email}' and contraseña'${Contraseña}'")
                    var RS2 =
                        statement?.executeQuery("select idpaciente, nombre, correo, contraseña from tbPacientes where correo='${Email}' and contraseña'${Contraseña}")

                    if (RS?.next()==false) {
                        Toast.makeText(this, "Email o contraseña inválidos", Toast.LENGTH_SHORT).show()
                    } else {

                        while (RS2?.next()==true){

                            val a1 = RS2.getString("correo")
                            val a2 = RS2.getString("contraseña")

                            if (Email==a1 && Contraseña==a2){

                            }

                        }
                    }
                } catch (ex: SQLException) {
                    Toast.makeText(this, "Error al mostrar", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
}