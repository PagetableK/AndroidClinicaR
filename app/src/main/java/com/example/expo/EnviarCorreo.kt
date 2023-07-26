package com.example.expo

import android.os.AsyncTask
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class EnviarCorreo(private val destinatario: String,
                   private val codigo: String):
    AsyncTask<Void?, Void?, Void?>() {

    override fun doInBackground(vararg params: Void?): Void? {


        val props = Properties()
        props["mail.smtp.host"] = "smtp.gmail.com"
        props["mail.smtp.socketFactory.port"] = "465"
        props["mail.smtp.socketFactory.class"] = "javax.net.ssl.SSLSocketFactory"
        props["mail.smtp.auth"] = "true"
        props["mail.smtp.port"] = "465"


        val session = Session.getDefaultInstance(props,
            object : javax.mail.Authenticator() {
                override fun getPasswordAuthentication(): PasswordAuthentication {
                    return PasswordAuthentication("correlibreriao@gmail.com", "ttqvuxxklpnishqx")
                }
            })


        try {
            val message = MimeMessage(session)

            message.setFrom(InternetAddress("mi_correo@gmail.com"))
            message.addRecipient(Message.RecipientType.TO, InternetAddress(destinatario))
            message.subject = "Código de recuperación"
            message.setText(this.codigo)
            Transport.send(message)

        } catch (e: MessagingException) {
            e.printStackTrace()

            println("El correo no se ha podido enviar")
        }
        return null
    }

}