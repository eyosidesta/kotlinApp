package com.example.kotlin_app

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var num1: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1 = findViewById(R.id.edtnum1)
        val btn_convert: Button = findViewById(R.id.btn_add)
        val rslt:TextView = findViewById(R.id.rslt)
        val spinnerCurrencyConversion:Spinner = findViewById(R.id.spinnerId)

        ArrayAdapter.createFromResource(
            this,
            R.array.currency_conversion,
            android.R.layout.simple_spinner_item
        ).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCurrencyConversion.adapter = adapter
        }

        spinnerCurrencyConversion.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                val currencyType = parent?.getItemAtPosition(position).toString()
                updateHint(currencyType)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // pass
            }
        }

        btn_convert.setOnClickListener{view ->
            val value = num1.text.toString().toDouble()
            if (value != null) {
                val currencyType = spinnerCurrencyConversion.selectedItem.toString()
                val result = convert(value, currencyType)
                val formatResult = String.format("%.2f", result)
                rslt.text = "The Currency Conversion From CAD to $currencyType is $formatResult"
            } else {
                rslt.text = "Please enter a valid number"
            }
        }
    }
    private fun updateHint(currencyType: String) {
        when (currencyType) {
            "USD" -> num1.hint = "Enter Currency to USD"
            "ETB" -> num1.hint = "Enter Currency to ETB"
            "YUAN" -> num1.hint = "Enter Currency to YUAN"
        }
    }

    private fun convert(value: Double, currencyType: String): Double {
        return when (currencyType) {
            "USD" -> (value) * 0.73
            "ETB" -> (value) * 42.19
            "YUAN" -> (value) * 5.31
            else -> value
        }
    }
}
