package com.example.agendacompose

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column

class MainActivity : ComponentActivity() {
    private var btnPlay: Button? = null
    private var btnPause: Button? = null
    private var btnStop: Button? = null
    private var mediaplayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mediaplayer = MediaPlayer.create(this, R.raw.amor);

            //Obtenemos los tres botones de la interfaz
            btnPlay= findViewById(R.drawable.);
            btnStop= findViewById(R.drawable.buttonStop);
            btnPause= findViewById(R.drawable.buttonPause);

            //Y les asignamos el controlador de eventos
            btnPlay!!.setOnClickListener(this);
            btnStop!!.setOnClickListener(this);
            btnPause!!.setOnClickListener(this);
        }
    }
}