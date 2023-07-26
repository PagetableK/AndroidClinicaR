package com.example.expo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

lateinit var Correo: EditText
lateinit var Boton: Button

class   RecuperaciondeCuenta : AppCompatActivity() {

    private var Conexionbase = Conexion();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperacionde_cuenta)

        Correo = findViewById(R.id.txtCorreo)
        Boton = findViewById(R.id.btnContinuar)

        Boton.setOnClickListener {

            if(Verificar(Correo.text.toString()) == false)
            {
                Toast.makeText(this, "El correo no ha sido utilizado en ninguna cuenta", Toast.LENGTH_LONG).show()
            }
            else
            {
                val randomNumber = (700000 until 999999).random()
                val Codigo: Intent = Intent(this, codigodeverificacion::class.java)
                Codigo.putExtra("0",randomNumber.toString())
                Codigo.putExtra("1", Correo.text.toString())
                startActivity(Codigo)
            }

        }

    }

    fun Verificar(correo: String): Boolean{

        val statement = Conexionbase.dbConn()?.createStatement()
        val resulSet = statement?.executeQuery("select correo from tbUsuarios where correo = '$correo';")

        if (resulSet?.next() == true)
        {
            val correo_usuario = resulSet?.getString("correo") ?: ""

            if(correo_usuario == "")
            {
                return false
            }
            else
            {
                return true
            }
        }
        else
        {
            println("a")
            return false
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}