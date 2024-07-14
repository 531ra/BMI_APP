package com.example.bmi_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shashank.sony.fancytoastlib.FancyToast
import kotlin.time.times

class calculateMainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculate_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name:EditText=findViewById(R.id.name)
        val age:EditText=findViewById(R.id.age)
       val weight:EditText=findViewById(R.id.weight)
        val heigth:EditText=findViewById(R.id.height)
        val btn:Button=findViewById(R.id.btn)







                           btn.setOnClickListener {
                               val name1=name.text.toString()
                               val age1=age.text.toString().toDoubleOrNull()
                               val weight1=weight.text.toString().toDoubleOrNull()
                               val heigth1=heigth.text.toString().toDoubleOrNull()

                               if (age1 != null && weight1 != null && heigth1 != null) {
                                   val bmi: Double = (weight1) / ((0.3048) * (0.3048) * heigth1*heigth1)
                                   val intent = Intent(this, resultMainActivity2::class.java)

                                   intent.apply {
                                       putExtra("name", name1)
                                       putExtra("age", age1)

                                       putExtra("result", bmi)
                                   }
                                   startActivity(intent)


                               } else {
                                   FancyToast.makeText(
                                       this,
                                       "Enter the value",
                                       FancyToast.LENGTH_LONG,
                                       FancyToast.WARNING,
                                       false
                                   ).show()
                               }

                           }
        }


    }
