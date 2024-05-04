package com.example.proyecto_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.json.JSONObject
import java.io.File


class MainActivity : AppCompatActivity() {
    lateinit var usernameInput : EditText
    lateinit var passwordInput : EditText
    lateinit var loginBtn : Button
    lateinit var signinbtn : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameInput = findViewById<EditText>(R.id.username_input)
        passwordInput = findViewById<EditText>(R.id.password_input)
        loginBtn = findViewById<Button>(R.id.logit_btn)
        signinbtn = findViewById<TextView>(R.id.signin_btn)


        signinbtn.setOnClickListener {
            val intent = Intent(this@MainActivity, SignInActivity::class.java)
            startActivity(intent)
        }



        loginBtn.setOnClickListener{
            val username =usernameInput.text.toString()
            val password =passwordInput.text.toString()

            val jsonString = loadJsonFromFile()
            val jsonObject = JSONObject(jsonString)

            // Obtener los valores del JSON
            val usernameCheck = jsonObject.getString("email")
            val passwordCheck = jsonObject.getString("password")

            Log.d("userinput", username)
            Log.d("user1input", usernameCheck)

            if (username == usernameCheck && passwordCheck ==password) {
                Toast.makeText(this, "¡Bienvenido!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, MainPage::class.java)
                startActivity(intent)
            }
            else Toast.makeText(this, "¡Usuario/Contraseña incorrecta!", Toast.LENGTH_SHORT).show()



        }


    }

    private fun loadJsonFromFile(): String {
        val fileName = "data.json"
        val directory = filesDir
        val file = File(directory, fileName)
        return file.readText()
    }
}