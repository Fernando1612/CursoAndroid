package com.example.senthil.kotlin_bottomnavigationview.Fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.senthil.kotlin_bottomnavigationview.Activity.gesto
import com.example.senthil.kotlin_bottomnavigationview.Activity.multimedia
import com.example.senthil.kotlin_bottomnavigationview.R

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(com.example.senthil.kotlin_bottomnavigationview.R.layout.fragment_second, container, false)

        val Gesto = view.findViewById(com.example.senthil.kotlin_bottomnavigationview.R.id.gesto) as Button
        Gesto.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, gesto::class.java)
            startActivity(intent)
        })
        return view
    }
}
