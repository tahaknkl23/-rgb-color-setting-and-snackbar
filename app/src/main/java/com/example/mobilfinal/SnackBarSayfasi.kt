package com.example.mobilfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatSpinner
import com.google.android.material.snackbar.Snackbar

class SnackBarSayfasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_bar_sayfasi)

        var button =findViewById<Button>(R.id.button3)
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

        val spinnerOptions = arrayOf(2, 2.5, 3,4)

        val spinner = findViewById<AppCompatSpinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val input1 = findViewById<AppCompatEditText>(R.id.input1).text.toString()
                val input2 = findViewById<AppCompatEditText>(R.id.input2).text.toString()

                val selectedValue = spinnerOptions[position]
                val duration = when (selectedValue) {
                    2 -> 2000 // 2 saniye
                    2.5 -> 2500 // 2.5 saniye
                    3 -> 3000 // 3 saniye
                    4 -> 4000 // 4 saniye
                    else -> 0
                }
                val snackBar = Snackbar.make(view!!, "$input1", duration.toInt())
                snackBar.setAction("$input2") {
                    Toast.makeText(applicationContext,"$input2",Toast.LENGTH_SHORT).show()
                }
                snackBar.show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Spinner'dan hiçbir seçim yapılmadığında burası çalışacak
            }
        }
    }
}