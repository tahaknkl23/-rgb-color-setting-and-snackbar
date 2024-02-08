package com.example.mobilfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast

class Secim : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secim)

        var resim =findViewById<ImageView>(R.id.resim);
        object : CountDownTimer(10000,500){
            override fun onTick(p0: Long) {
                var a=p0.toInt()
                a=a/100
                if (a % 2 == 0){
                    resim.visibility= View.VISIBLE
                }
                else{
                    resim.visibility= View.INVISIBLE
                }

            }

            override fun onFinish() {
                resim.visibility= View.VISIBLE

            }

        }.start()


       var button =findViewById<Button>(R.id.button)
        button.setOnClickListener{
            var acilirmenu =PopupMenu(this,button)
            acilirmenu.menuInflater.inflate(R.menu.popupmenu,acilirmenu.menu)
            acilirmenu.setOnMenuItemClickListener { i->
                when(i.itemId){
                    R.id.RGB ->{
                        val gecis=Intent(applicationContext,RGB::class.java)
                        startActivity(gecis)
                        true
                    }
                    R.id.Snack_Bar ->{
                        val gecis=Intent(applicationContext,SnackBarSayfasi::class.java)
                        startActivity(gecis)
                        true
                    }
                    R.id.Cikis ->{
                        val gecis=Intent(applicationContext,CikisYapSayfasi::class.java)
                        startActivity(gecis)
                        true
                    }
                    else -> false
                }
            }
            acilirmenu.show()
        }
    }
}