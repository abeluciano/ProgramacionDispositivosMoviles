package com.example.ejercicio03

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.SeekBar

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var runnable: Runnable
    private var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play_btn = findViewById<ImageButton>(R.id.play_btn)
        val seekbar = findViewById<SeekBar>(R.id.seekbar)

        val mediaPlayer = MediaPlayer.create(this,R.raw.music)

        seekbar.progress = 0
        seekbar.max = mediaPlayer.duration

        play_btn.setOnClickListener {

            if(!mediaPlayer.isPlaying){
                mediaPlayer.start()
                play_btn.setImageResource(R.drawable.baseline_pause_24)
            }else{
                mediaPlayer.pause()
                play_btn.setImageResource(R.drawable.baseline_play_arrow_24)
            }
        }
        seekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed:Boolean) {
                if(changed){
                    mediaPlayer.seekTo(pos)
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        runnable = Runnable {
            seekbar.progress=mediaPlayer.currentPosition
            handler.postDelayed(runnable, 10000)
        }
        handler.postDelayed(runnable, 10000)

        mediaPlayer.setOnCompletionListener {
            play_btn.setImageResource(R.drawable.baseline_play_arrow_24)
            seekbar.progress= 0
        }
    }
}