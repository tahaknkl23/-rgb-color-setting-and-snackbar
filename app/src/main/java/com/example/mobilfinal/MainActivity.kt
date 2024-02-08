package com.example.mobilfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.PopupMenu
import android.widget.ProgressBar
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            var seekbar = findViewById<SeekBar>(R.id.seekBar);
            var progesbar = findViewById<ProgressBar>(R.id.progressBar);

            progesbar.visibility = View.INVISIBLE
            seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    if (progress == 100) {
                        progesbar.visibility = View.VISIBLE
                        val gecis = Intent(applicationContext, Login::class.java)
                        startActivity(gecis)
                        finish()
                    }

                }

                override fun onStartTrackingTouch(p0: SeekBar?) {

                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                    if (seekbar.progress != 100) {
                        seekbar.progress = 0
                    }
                }

            } )

        }
    }