package com.yuvanandhinir.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    // Anonymous Functions For Each Operations
    private val add = { firstNumber: Double, secondNumber: Double -> firstNumber + secondNumber }
    private val subtract = { firstNumber: Double, secondNumber: Double -> firstNumber - secondNumber }
    private val multiply = { firstNumber: Double, secondNumber: Double -> firstNumber * secondNumber }
    private val divide = { firstNumber: Double, secondNumber: Double -> firstNumber / secondNumber }

    // onCreate Life-Cycle Method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set OnClickListeners
        initListeners()
    }

    // Function Which Sets OnClickListeners To Each Buttons
    private fun initListeners() {
        buttonAdd.setOnClickListener {
            setOutputWithOperation(add)
        }

        buttonSubtract.setOnClickListener {
            setOutputWithOperation(subtract)
        }

        buttonMultiply.setOnClickListener {
            setOutputWithOperation(multiply)
        }

        buttonDivide.setOnClickListener {
            setOutputWithOperation(divide)
        }

    }

    // Commonly Extracted Function
    private fun setOutputWithOperation(operation: (Double, Double) -> Double) {
        val firstNumber = editTextFirstNumber.toDouble()
        val secondNumber = editTextSecondNumber.toDouble()
        labelOutput.text = operation(firstNumber, secondNumber).formatted()
    }
}

// Global Decimal Formatter
val decimalFormat = DecimalFormat("#.##")

// Simple Extension Method To Convert EditText.text To Double
fun EditText.toDouble() = this.text.toString().toDouble()

// Simple Extension Method To Format Double With decimalFormat
fun Double.formatted(): String = decimalFormat.format(this)
