package com.example.ejercicio03

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    lateinit var runnable: Runnable
    private var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val play_btn = findViewById<ImageButton>(R.id.play_btn)
        val stop_btn = findViewById<ImageButton>(R.id.stop_btn)
        val prev_btn = findViewById<ImageButton>(R.id.prev_btn)
        val next_btn = findViewById<ImageButton>(R.id.next_btn)
        val mediaPlayer = mutableListOf(
            MediaPlayer.create(this, R.raw.creep),
            MediaPlayer.create(this, R.raw.ella_y_el),
            MediaPlayer.create(this, R.raw.music),
            MediaPlayer.create(this, R.raw.snuff),
            MediaPlayer.create(this, R.raw.still_loving_you),
        )
        val nombresCanciones = arrayOf("Creep - Radiohead", "Ella y Él - Pedro Suarez Vertiz", "lofipop", "Snuff -  Slipknot", "Still loving you - Scorpions")
        val textView = findViewById<TextView>(R.id.txt_music)
        val seekbar = findViewById<SeekBar>(R.id.seekbar)

        val musica= intent.getIntExtra("cancionSeleccionada", 0)
        textView.text = nombresCanciones[musica]
        var pos = musica
        seekbar.progress = 0
        seekbar.max = mediaPlayer[pos].duration



        play_btn.setOnClickListener {
            if (!mediaPlayer[pos].isPlaying) {
                mediaPlayer[pos].start()
                play_btn.setImageResource(R.drawable.baseline_pause_24)
            } else {
                mediaPlayer[pos].pause()
                play_btn.setImageResource(R.drawable.baseline_play_arrow_24)
            }

        }

        stop_btn.setOnClickListener {
            if (mediaPlayer[pos].isPlaying) {
                mediaPlayer[pos].stop()
                mediaPlayer[pos].prepareAsync()
            }
            mediaPlayer[0]
            seekbar.progress = 0
            play_btn.setImageResource(R.drawable.baseline_play_arrow_24)
        }

        prev_btn.setOnClickListener {
            if(mediaPlayer[pos].isPlaying) {
                mediaPlayer[pos].stop()
                pos --
                mediaPlayer[pos].start()
            } else if (!mediaPlayer[pos].isPlaying) {
                pos --
            }
        }

        next_btn.setOnClickListener {
            if(mediaPlayer[pos].isPlaying) {
                mediaPlayer[pos].stop()
                pos ++
                mediaPlayer[pos].start()
            } else if (!mediaPlayer[pos].isPlaying) {
                pos ++
            }
        }

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                if (changed) {
                    mediaPlayer[pos].seekTo(pos)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        runnable = Runnable {
            seekbar.progress = mediaPlayer[pos].currentPosition
            handler.postDelayed(runnable, 10000)
        }
        handler.postDelayed(runnable, 10000)

        mediaPlayer[pos].setOnCompletionListener {
            play_btn.setImageResource(R.drawable.baseline_play_arrow_24)
            seekbar.progress = 0
        }
    }

}