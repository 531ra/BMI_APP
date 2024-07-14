package com.example.bmi_app

import android.graphics.Color
import android.graphics.Color.YELLOW
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class resultMainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val age:Double=intent.getDoubleExtra("age",0.0)
        val name:String= intent.getStringExtra("name").toString()
        val bmi:Double=intent.getDoubleExtra("result",0.0)
        val layout = findViewById<ConstraintLayout>(R.id.main1)


        val name_:TextView=findViewById(R.id.name)
        val age_:TextView=findViewById(R.id.age)
        val result:TextView=findViewById(R.id.result)

val add=   when {
            bmi < 18.5 -> "Underweight"
            bmi < 24.9 -> "Normal"
            bmi < 29.9 -> "overweight"
            else ->"none"
        }

        name_.text=name
    result.text="Your BMI=${bmi.toFloat()}% so,you are-$add"
        age_.text= age.toString()
        val color = when {
            bmi < 18.5 -> Color.parseColor("#ADD8E6") // Light Blue for Underweight
            bmi < 24.9 -> Color.parseColor("#90EE90") // Light Green for Normal weight
            bmi < 29.9 -> Color.parseColor("#FFD700") // Yellow for Overweight
            else -> Color.parseColor("#FF4500") // Orange Red for Obesity
        }
        layout.setBackgroundColor(color)


    }
}