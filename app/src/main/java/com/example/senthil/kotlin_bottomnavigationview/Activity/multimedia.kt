package com.example.senthil.kotlin_bottomnavigationview.Activity

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.speech.RecognizerIntent
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import com.example.senthil.kotlin_bottomnavigationview.R

import kotlinx.android.synthetic.main.activity_multimedia.*

class multimedia : AppCompatActivity() {

    companion object {
        private val IMAGE_CODE =123
        private val PHOTO_CODE=1
        private val AUDIO_CODE=456
        private val VIDEO_CODE=789
        private val GRABAR_AUDIO=12
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multimedia)

        boton1.setOnClickListener {
            elegirAudio()
        }
        boton2.setOnClickListener {
            elegirImagen()
        }
        boton3.setOnClickListener {
            elegirVideo()
        }
        boton4.setOnClickListener {
            grabarAudio()
        }
        boton5.setOnClickListener {
            llamar()
        }
        boton6.setOnClickListener {
            tomarFoto()
        }

    }
    fun elegirAudio (){
        val intent= Intent()
        intent.type="audio/*"
        intent.action=Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, AUDIO_CODE)
    }
    fun grabarAudio () {
        val intent=Intent()
        intent.action= RecognizerIntent.ACTION_RECOGNIZE_SPEECH
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,"es-MX")
        try {
            startActivityForResult(intent, GRABAR_AUDIO)
        } catch (anfe : ActivityNotFoundException) {
            Toast.makeText(applicationContext,"No tienes microfono",Toast.LENGTH_SHORT).show()
        }
    }
    fun elegirImagen () {
        val intent=Intent()
        intent.type="image/*"
        intent.action=Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, IMAGE_CODE)
    }
    fun elegirVideo () {
        val intent=Intent()
        intent.type="video/*"
        intent.action=Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, VIDEO_CODE)
    }
    fun llamar () {
        val phone = "5526839737"
        val intent = Intent()
        intent.action=Intent.ACTION_CALL
        intent.data= Uri.parse("tel: "+phone)
        //Permisos
        val permiso = ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)
        if(permiso!= PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", " no puedes hacer llamadas")
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),225)
        } else {
            Log.i("Mensaje"," Aahh perro si puedes llamar")
            if(intent.resolveActivity(packageManager)!=null) {
                startActivity(intent)
            }
        }
    }
    fun tomarFoto() {
        var i=Intent()
        i.action= MediaStore.ACTION_IMAGE_CAPTURE
        startActivityForResult(i, PHOTO_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(Activity.RESULT_OK== PHOTO_CODE) {
            val extras = data?.extras
            val imageBit = extras?.get("data") as Bitmap
            imagen.setImageBitmap(imageBit)
            imagen.visibility= View.VISIBLE
        }
        else if(GRABAR_AUDIO==requestCode) {
            val speech=data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            txt.setText(speech?.get(0))
            txt.visibility=View.VISIBLE
            imagen.visibility=View.GONE

        }
        else if(AUDIO_CODE==requestCode) {
            val audio=data?.data
            val audioController = MediaController(this)
            audioController.setAnchorView(video)
            video.visibility=View.VISIBLE
            imagen.visibility=View.GONE
            video.setMediaController(audioController)
            try {
                video.setVideoURI(audio)
            }catch (e : Exception) {
                e.printStackTrace()
            }
            Toast.makeText(this,"Inicia audio...",Toast.LENGTH_SHORT).show()
        }
        else if (IMAGE_CODE==requestCode) {
            val image=data?.data
            imagen.setImageURI(image)
            imagen.visibility=View.VISIBLE
            Toast.makeText(this,"Inicia imagen...",Toast.LENGTH_SHORT).show()
        }
        else if(VIDEO_CODE==requestCode) {
            val videoo = data?.data
            val videoController=MediaController(this)
            videoController.setAnchorView(video)
            video.visibility=View.VISIBLE
            imagen.visibility=View.GONE
            video.setMediaController(videoController)
            try {
                video.setVideoURI(videoo)
            }catch (e : Exception) {
                e.printStackTrace()
            }
            Toast.makeText(this,"Inicia video...",Toast.LENGTH_SHORT).show()
        }
    }
}
