package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button   // libreria para button
import android.widget.EditText // libreria editext
import android.widget.TextView  // libreria textview

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et1 = findViewById<EditText>(R.id.et1)
        val tv1 = findViewById<TextView>(R.id.tv1)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val grados = et1.text.toString().toDoubleOrNull()

            if (grados != null) {
                val radianes = convertirARadianes(grados)

                tv1.text = "Radianes: $radianes"

                System.out.println("Grados: $grados -> Radianes: $radianes")

                Log.d(TAG, "Grados: $grados -> Radianes: $radianes")
            } else {
                tv1.text = "Ingresa un número válido"
            }
        }
    }
   private fun convertirARadianes(grados: Double): Double {
        return grados * Math.PI / 180.0
    }
}

