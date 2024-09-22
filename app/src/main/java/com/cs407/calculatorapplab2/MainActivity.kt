package com.cs407.calculatorapplab2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstEditText = findViewById<EditText>(R.id.firstNumEditText)
        val secondEditText = findViewById<EditText>(R.id.secondNumEditText)

        val plusButton = findViewById<Button>(R.id.plusButton)
        plusButton.setOnClickListener {

            val firstNum = firstEditText.text.toString().toDouble()
            val secondNum = secondEditText.text.toString().toDouble()

            val result = firstNum + secondNum

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("EXTRA_RESULT", "Result: $result")

            startActivity(intent)
        }

        val minusButton = findViewById<Button>(R.id.minusButton)
        minusButton.setOnClickListener {

            val firstNum = firstEditText.text.toString().toDouble()
            val secondNum = secondEditText.text.toString().toDouble()

            val result = firstNum - secondNum

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("EXTRA_RESULT", "Result: $result")

            startActivity(intent)
        }

        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        multiplyButton.setOnClickListener {

            val firstNum = firstEditText.text.toString().toDouble()
            val secondNum = secondEditText.text.toString().toDouble()

            val result = firstNum * secondNum

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("EXTRA_RESULT", "Result: $result")

            startActivity(intent)
        }

        val divideButton = findViewById<Button>(R.id.divideButton)
        divideButton.setOnClickListener {

            val firstNum = firstEditText.text.toString().toDouble()
            val secondNum = secondEditText.text.toString().toDouble()

            if (secondNum == 0.0) {
                Toast.makeText(this, "Error: Cannot divide by zero", Toast.LENGTH_SHORT).show()

            } else {
                val result = firstNum / secondNum

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_RESULT", "Result: $result")

                startActivity(intent)
            }

        }



    }
}