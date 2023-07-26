package com.example.expo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

lateinit var BotonCambiar: Button
lateinit var Nuevacontra: EditText

class CambiarContra : AppCompatActivity() {

    private var Conexionbase = Conexion();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambiar_contra)

        BotonCambiar = findViewById(R.id.btnRestablecer)
        Nuevacontra = findViewById(R.id.txtNuevaContra)

        BotonCambiar.setOnClickListener {

            val Correo: String = intent.getStringExtra("correo")!!

            if(Nuevacontra.text.toString().trim() != "")
            {
                RestablecerContra(Correo, Nuevacontra.text.toString())

                Toast.makeText(this, "Contraseña restablecida", Toast.LENGTH_SHORT).show()

                finish()
            }
            else
            {
                Toast.makeText(this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun RestablecerContra(correo: String, contra: String)
    {
        try {
            val AgregarUsuario = Conexionbase.dbConn()?.prepareStatement("update tbusuarios set contraseña = '$contra' where correo = '$correo';")!!
            AgregarUsuario.executeUpdate()
        }
        catch (e: java.lang.Exception)
        {

            Toast.makeText(this, "Ha habido un error en la aplicación", Toast.LENGTH_LONG).show()
        }
    }
}