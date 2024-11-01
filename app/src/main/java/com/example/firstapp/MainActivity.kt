package com.example.firstapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editTextET: EditText
    private lateinit var resultR: TextView
    private lateinit var amountA: TextView
    private lateinit var buttonBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextET = findViewById(R.id.editTextET)
        resultR = findViewById(R.id.resultR)
        amountA = findViewById(R.id.amountA)
        buttonBTN = findViewById(R.id.buttonBTN)

        onButtonClick(buttonBTN)

    }

    fun onButtonClick(view: View) {
        val sendText = editTextET.text
        resultR.text = sendText.reversed()
        amountA.text = "Количество символов: " + sendText.filter { it != ' ' }.length.toString()
    }

}