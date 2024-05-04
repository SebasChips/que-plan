package com.example.proyecto_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        lateinit var logout : Button
        logout = findViewById<Button>(R.id.logout)


        logout.setOnClickListener {
            val intent = Intent(this@MainPage, MainActivity::class.java)
            startActivity(intent)
        }
    }

}