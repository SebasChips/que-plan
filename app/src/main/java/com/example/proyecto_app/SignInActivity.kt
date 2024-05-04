package com.example.proyecto_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream

class SignInActivity : AppCompatActivity() {
    lateinit var loginAct : TextView
    lateinit var signinButton : TextView
    lateinit var nameSignIn : EditText
    lateinit var lastname : EditText
    lateinit var emailSignin : EditText
    lateinit var passwordSigin : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        loginAct =  findViewById<TextView>(R.id.loginActivity)
        signinButton =  findViewById<TextView>(R.id.signinButton)


        loginAct.setOnClickListener {
            val intent = Intent(this@SignInActivity, MainActivity::class.java)
            startActivity(intent)
        }

        loginAct =  findViewById<TextView>(R.id.loginActivity)
        signinButton =  findViewById<TextView>(R.id.signinButton)
        nameSignIn = findViewById(R.id.nameSignin)
        lastname = findViewById(R.id.lastnameSignin)
        emailSignin = findViewById(R.id.emailSignin)
        passwordSigin = findViewById(R.id.passwordSigin)





        signinButton.setOnClickListener {
            val username = nameSignIn.text.toString()
            val lastname = lastname.text.toString()
            val emailSignin = emailSignin.text.toString()
            val passwordSigin = passwordSigin.text.toString()


            // Crear un objeto JSON
            val jsonObject = JSONObject()
            jsonObject.put("name", username)
            jsonObject.put("lastname", lastname)
            jsonObject.put("email", emailSignin)
            jsonObject.put("password", passwordSigin)


            // Convertir el objeto JSON a String
            val jsonString = jsonObject.toString()
            Log.d("JSON", jsonString)
            saveJsonToFile(jsonString)


        }
    }
    private fun saveJsonToFile(jsonString: String) {
        val fileName = "data.json"

        // Obtener el directorio de archivos internos de la aplicación
        val directory = filesDir

        // Crear un nuevo archivo en el directorio de archivos internos
        val file = File(directory, fileName)

        // Escribir el JSON en el archivo
        FileOutputStream(file).use { stream ->
            stream.write(jsonString.toByteArray())
        }
        Toast.makeText(this, "¡Cuenta creada con éxito!", Toast.LENGTH_SHORT).show()

    }
}