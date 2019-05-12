package com.example.senthil.kotlin_bottomnavigationview.Fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.senthil.kotlin_bottomnavigationview.Activity.Eventos
import com.example.senthil.kotlin_bottomnavigationview.Activity.NavegacionLateral
import com.example.senthil.kotlin_bottomnavigationview.Activity.Servicio
import com.example.senthil.kotlin_bottomnavigationview.Activity.multimedia


class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(com.example.senthil.kotlin_bottomnavigationview.R.layout.fragment_first, container, false)

        val btnLanzarActivity = view.findViewById(com.example.senthil.kotlin_bottomnavigationview.R.id.multi) as Button
        btnLanzarActivity.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, multimedia::class.java)
            startActivity(intent)
        })

        val btnEvento = view.findViewById(com.example.senthil.kotlin_bottomnavigationview.R.id.even) as Button
        btnEvento.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, Eventos::class.java)
            startActivity(intent)
        })

        val btnServicio = view.findViewById(com.example.senthil.kotlin_bottomnavigationview.R.id.serv) as Button
        btnServicio.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, Servicio::class.java)
            startActivity(intent)
        })

        val btnLateral = view.findViewById(com.example.senthil.kotlin_bottomnavigationview.R.id.lateral) as Button
        btnLateral.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, NavegacionLateral::class.java)
            startActivity(intent)
        })


        return view
    }



}
