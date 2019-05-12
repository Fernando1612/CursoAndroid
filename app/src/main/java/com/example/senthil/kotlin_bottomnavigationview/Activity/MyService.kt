package com.example.senthil.kotlin_bottomnavigationview.Activity

import android.app.Service
import android.content.ContentValues.TAG
import android.content.Intent
import android.media.MediaPlayer
import android.media.audiofx.BassBoost
import android.os.IBinder
import android.provider.Settings
import android.util.Log

class MyService : Service() {

    lateinit var miRep:MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //  mostrarLog("Funcion on start")

        //    for(i in 1..10)
        //  {
        //   mostrarLog("Segundo plano: "+i.toString())
        //   Thread.sleep(1000)
        //  }

        // return super.onStartCommand(intent, flags, startId)

        miRep = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        miRep.isLooping = true
        miRep.start()

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        miRep.stop()
    }

    fun mostrarLog(mensaje:String)
    {
        Log.i(TAG,mensaje)

    }
}
