package com.example.mobilfinal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {
    private lateinit var isimSoyisimEditText: EditText
    private lateinit var ogrNoEditText: EditText
    private lateinit var beniHatirlaSwitch: Switch
    private lateinit var girisBasariliTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        if (sharedPreferences.getBoolean("beni_hatirla", false)) {
            val gecis = Intent(applicationContext, Secim::class.java)
            startActivity(gecis)
            finish()
        }

        isimSoyisimEditText = findViewById(R.id.isim_soyisim_edit_text)
        ogrNoEditText = findViewById(R.id.ogr_no_edit_text)
        beniHatirlaSwitch = findViewById(R.id.beni_hatirla_switch)
        girisBasariliTextView = findViewById(R.id.giris_basarili_text_view)

        isimSoyisimEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                girisYap()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        ogrNoEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                girisYap()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        beniHatirlaSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                hatirla()
                val beni_hatirla = true

            }
        }
    }

    private fun hatirla() {
        val isimSoyisim = isimSoyisimEditText.text.toString()
        val ogrNo = ogrNoEditText.text.toString()

        val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("isim_soyisim", isimSoyisim)
        editor.putString("ogr_no", ogrNo)
        val beni_hatirla = true
        editor.putBoolean("beni_hatirla", beni_hatirla)
        editor.apply()
    }

    private fun girisYap() {
        val isimSoyisim = isimSoyisimEditText.text.toString()
        val ogrNo = ogrNoEditText.text.toString()

        if (isimSoyisim == "taha kunkul" && ogrNo == "02205076060") {
            girisBasariliTextView.visibility = View.VISIBLE

            // SharedPreferences nesnesini oluşturun
            val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)

            // SharedPreferences'da veri var ise "Secim" sayfasına yönlendir
            if (sharedPreferences.contains("isim_soyisim") && sharedPreferences.contains("ogr_no")) {
                val gecis = Intent(applicationContext, Secim::class.java)
                startActivity(gecis)
                finish()
            }

            val gecis = Intent(applicationContext, Secim::class.java)
            startActivity(gecis)
            finish()
        } else {
            girisBasariliTextView.visibility = View.GONE
        }
    }
}
