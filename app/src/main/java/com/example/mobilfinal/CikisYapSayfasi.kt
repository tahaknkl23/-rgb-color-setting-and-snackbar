package com.example.mobilfinal

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Handler
import android.view.View
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity




class CikisYapSayfasi : AppCompatActivity() {

        private lateinit var input1: EditText
        private lateinit var input2: EditText

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Dialog penceresini oluştur
            val builder = AlertDialog.Builder(this)
            //builder.setTitle("Login")

            // Dialog penceresine ait layout'u inflate et
            val layout = layoutInflater.inflate(R.layout.activity_cikis_yap_sayfasi, null)

            // Dialog penceresine layout'u ekle
            builder.setView(layout)

            // Dialog penceresine input değerlerini ekle
            val input1 = layout.findViewById<EditText>(R.id.input1)
            val input2 = layout.findViewById<EditText>(R.id.input2)

            // Kullanıcı input değerlerini girmeye başladığında çalışacak listener
            input1.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    // Kullanıcı input değerlerini girmeye başladığında çalışacak fonksiyon
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    val inputValue = s.toString()
                    if (inputValue == "taha kunkul") {
                        val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
                        val editor = sharedPreferences.edit()
                        editor.clear()
                        editor.apply()

                        // Eğer girilen metin "Turker Tastan" ise gerekli aksiyonları al
                    }

                }
            })

            input2.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    // Kullanıcı input değerlerini girmeye başladığında çalışacak fonksiyon
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    val inputValue = s.toString()
                    if (inputValue == "02205076060") {
                        // Eğer input değerleri doğru girildiyse Login sayfasına yönlendir
                        val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
                        val editor = sharedPreferences.edit()
                        editor.clear()
                        editor.apply()
                        val intent = Intent(applicationContext, Login::class.java)
                        startActivity(intent)


                    }

                }
            })

            // Dialog penceresini göster
            builder.show()
        }
    }