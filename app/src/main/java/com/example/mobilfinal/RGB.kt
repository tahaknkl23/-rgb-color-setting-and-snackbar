package com.example.mobilfinal


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RGB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rgb)

        // SeekBar widget'larını tanımlayın
        val redSeekBar: SeekBar = findViewById(R.id.redSeekBar)
        val greenSeekBar: SeekBar = findViewById(R.id.greenSeekBar)
        val blueSeekBar: SeekBar = findViewById(R.id.blueSeekBar)
        val colorTextView: TextView = findViewById(R.id.colorTextView)
        val contentView: RelativeLayout = findViewById(R.id.contentView)

        var button =findViewById<Button>(R.id.button2)
        button.setOnClickListener{
            var acilirmenu = PopupMenu(this,button)
            acilirmenu.menuInflater.inflate(R.menu.popupmenu,acilirmenu.menu)
            acilirmenu.setOnMenuItemClickListener { i->
                when(i.itemId){
                    R.id.RGB ->{
                        val gecis= Intent(applicationContext,RGB::class.java)
                        startActivity(gecis)
                        true
                    }
                    R.id.Snack_Bar ->{
                        val gecis= Intent(applicationContext,SnackBarSayfasi::class.java)
                        startActivity(gecis)
                        true
                    }
                    R.id.Cikis ->{
                        val gecis= Intent(applicationContext,CikisYapSayfasi::class.java)
                        startActivity(gecis)
                        true
                    }
                    else -> false
                }
            }
            acilirmenu.show()

        }

        // Her bir çubuğun değiştirilmesi durumunda arka plan rengini değiştirin
        redSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val red = redSeekBar.progress
                val green = greenSeekBar.progress
                val blue = blueSeekBar.progress
                val color = Color.rgb(red, green, blue)
                contentView.setBackgroundColor(color)
                val hexColor = String.format("#%06X", 0xFFFFFF and color)
                colorTextView.text = hexColor
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Bu fonksiyonu boş bırakabilirsiniz veya burada bir işlem yapabilirsiniz
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Bu fonksiyonu boş bırakabilirsiniz veya burada bir işlem yapabilirsiniz
            }
        })

        greenSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val red = redSeekBar.progress
                val green = greenSeekBar.progress
                val blue = blueSeekBar.progress
                val color = Color.rgb(red, green, blue)
                contentView.setBackgroundColor(color)
                val hexColor = String.format("#%06X", 0xFFFFFF and color)
                colorTextView.text = hexColor
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Bu fonksiyonu boş bırakabilirsiniz veya burada bir işlem yapabilirsiniz
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Bu fonksiyonu boş bırakabilirsiniz veya burada bir işlem yapabilirsiniz
            }
        })

        blueSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val red = redSeekBar.progress
                val green = greenSeekBar.progress
                val blue = blueSeekBar.progress
                val color = Color.rgb(red, green, blue)
                contentView.setBackgroundColor(color)
                val hexColor = String.format("#%06X", 0xFFFFFF and color)
                colorTextView.text = hexColor
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Bu fonksiyonu boş bırakabilirsiniz veya burada bir işlem yapabilirsiniz
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Bu fonksiyonu boş bırakabilirsiniz veya burada bir işlem yapabilirsiniz
            }
        })
    }
}