package com.cindy.kalkulator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val panjang: EditText = findViewById<View>(R.id.panjang) as EditText
        val lebar: EditText = findViewById<View>(R.id.lebar) as EditText
        val persegiButton: Button = findViewById<View>(R.id.btnPersegi) as Button
        val segitiaButton: Button = findViewById<View>(R.id.btnSegitiga) as Button
        val lingkaranButton: Button = findViewById<View>(R.id.btnLingkaran) as Button

        persegiButton.setOnClickListener {
            val panjangResult = panjang.text.toString()
            val lebarResult = lebar.text.toString()
            if (panjangResult.isEmpty()) {
                Toast.makeText(this, "Panjang tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (lebarResult.isEmpty()) {
                Toast.makeText(this, "Lebar tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                callPersegi(panjangResult.toDouble(), lebarResult.toDouble())
            }
        }
        segitiaButton.setOnClickListener {
            val panjangResult = panjang.text.toString()
            val lebarResult = lebar.text.toString()
            if (panjangResult.isEmpty()) {
                Toast.makeText(this, "Panjang tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (lebarResult.isEmpty()) {
                Toast.makeText(this, "Lebar tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                callSegitiga(panjangResult.toDouble(), lebarResult.toDouble())
            }
        }
        lingkaranButton.setOnClickListener {
            val panjangResult = panjang.text.toString()
            if (panjangResult.isEmpty()) {
                Toast.makeText(this, "Panjang tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                callLingkaran(panjangResult.toDouble())
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun callPersegi(panjangParam: Double, lebarParam: Double) {
        val luas: TextView = findViewById<View>(R.id.labelLuas) as TextView
        val keliling: TextView = findViewById<View>(R.id.labelKeliling) as TextView
        val resultL = panjangParam * lebarParam
        val resultK = panjangParam * 2 + lebarParam * 2
        luas.text = "Luas : " + String.format("%.2f", resultL)
        keliling.text = "Keliling : " + String.format("%.2f", resultK)
    }

    @SuppressLint("SetTextI18n")
    private fun callSegitiga(panjangParam: Double, lebarParam: Double) {
        val luas: TextView = findViewById<View>(R.id.labelLuas) as TextView
        val keliling: TextView = findViewById<View>(R.id.labelKeliling) as TextView
        val resultL = panjangParam * lebarParam / 2
        val sisi: Double = sqrt(panjangParam.pow(2.0) + lebarParam.pow(2.0))
        val resultK = panjangParam + lebarParam + sisi
        luas.text = "Luas : " + String.format("%.2f", resultL)
        keliling.text = "Keliling : " + String.format("%.2f", resultK)
    }

    @SuppressLint("SetTextI18n")
    private fun callLingkaran(panjangParam: Double) {
        val luas: TextView = findViewById<View>(R.id.labelLuas) as TextView
        val keliling: TextView = findViewById<View>(R.id.labelKeliling) as TextView
        val num2 = panjangParam / 2
        val resultL = Math.PI * num2.pow(2.0)
        val resultK = 2 * Math.PI * num2
        luas.text = "Luas : " + String.format("%.2f", resultL)
        keliling.text = "Keliling : " + String.format("%.2f", resultK)
    }
}