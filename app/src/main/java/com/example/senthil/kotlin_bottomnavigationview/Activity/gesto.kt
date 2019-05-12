package com.example.senthil.kotlin_bottomnavigationview.Activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.senthil.kotlin_bottomnavigationview.R

import kotlinx.android.synthetic.main.activity_gesto.*

class gesto : AppCompatActivity() {

    lateinit var textMsg: TextView
    lateinit var myImage: ImageView

    private var scaleGestureDetector: ScaleGestureDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gesto)

        textMsg = findViewById<View>(R.id.msg) as TextView
        myImage = findViewById<View>(R.id.myimage) as ImageView

        scaleGestureDetector = ScaleGestureDetector(
                this, MySimpleOnScaleGestureListener(textMsg, myImage))

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        scaleGestureDetector!!.onTouchEvent(event)
        return true
        //return super.onTouchEvent(event);
    }

    private inner class MySimpleOnScaleGestureListener(
            internal var viewMessage: TextView,
            internal var viewMyImage: ImageView
    ) : ScaleGestureDetector.SimpleOnScaleGestureListener() {

        internal var factor: Float = 0.toFloat()

        override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
            factor = 1.0f
            return true
            //return super.onScaleBegin(detector);
        }

        override fun onScale(detector: ScaleGestureDetector): Boolean {

            val scaleFactor = detector.getScaleFactor() - 1
            factor += scaleFactor
            viewMessage.setText(
                    scaleFactor.toString()
                            + "\n" + factor.toString()
            )
            viewMyImage.setScaleX(factor)
            viewMyImage.setScaleY(factor)
            return true
            //return super.onScale(detector);
        }
    }
}
