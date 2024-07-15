package com.example.kotlin_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1:EditText = findViewById(R.id.edtnum1)
        val num2:EditText = findViewById(R.id.edtnum2)
        val btn_add:Button = findViewById(R.id.btn_add)
        val btn_sub:Button = findViewById(R.id.btn_sub)
        val btn_mul:Button = findViewById(R.id.btn_mul)
        val btn_div:Button = findViewById(R.id.btn_div)
        val rslt:TextView = findViewById(R.id.rslt)



        btn_add.setOnClickListener{view ->
            var getNum1:Int = num1.text.toString().toInt()
            var getNum2:Int = num2.text.toString().toInt()
            var result = getNum1 + getNum2
            rslt.text = "Result $result"
        }
        btn_sub.setOnClickListener{view ->
            val getNum1:Int = num1.text.toString().toInt()
            val getNum2:Int = num2.text.toString().toInt()
            val result = getNum1 - getNum2
            rslt.text = "Result $result"
        }
        btn_mul.setOnClickListener{view ->
            val getNum1:Int = num1.text.toString().toInt()
            val getNum2:Int = num2.text.toString().toInt()
            val result = getNum1 * getNum2
            rslt.text = "Result $result"
        }
        btn_div.setOnClickListener{view ->
            val getNum1:Int = num1.text.toString().toInt()
            val getNum2:Int = num2.text.toString().toInt()
            val result = getNum1 / getNum2
            rslt.text = "Result $result"
        }
    }
}