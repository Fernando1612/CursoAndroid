package com.example.senthil.kotlin_bottomnavigationview.Activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.example.senthil.kotlin_bottomnavigationview.R

import kotlinx.android.synthetic.main.activity_servicio.*

class Servicio : AppCompatActivity() {

    var encendido = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicio)

        button.setOnClickListener {
            if(encendido<1)
            {
                val intent = Intent(this,MyService::class.java)
                startService(intent)
                encendido++
            }

        }
        button2.setOnClickListener {

            val intent = Intent(this, MyService::class.java)
            stopService(intent)
            encendido = 0
        }
    }

}
