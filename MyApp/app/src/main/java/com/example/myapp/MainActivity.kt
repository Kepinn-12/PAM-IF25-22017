package com.example.myapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var angkaBulat : Int = 0
//    val angkaDesimal : Double = 14.1
//
//    val angkaArray : Array <Int> = arrayOf(1,2,3,4,5)
//    val StringArray : Array<String> = arrayOf("Aku", "Adalah", "Kevin")
//
//    var cek : Boolean = false
//    var kalimat : String = "Cek broo"
    fun hitung(){
        angkaBulat++
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.text_view)
        val btnHitung : Button = findViewById(R.id.button_hitung)

        btnHitung.setOnClickListener {
            hitung ()
            textView.text = angkaBulat.toString()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}