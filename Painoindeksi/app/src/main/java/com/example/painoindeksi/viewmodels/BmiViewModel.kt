package com.example.painoindeksi.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class BmiViewModel: ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")
    private val formatter = DecimalFormat("0.0")

    val bmi: Float
        get() {
            val height = heightInput.toFloatOrNull() ?: 0f
            val weight = weightInput.toFloatOrNull() ?: 0f
            return if (height > 0 && weight > 0) {
                weight / (height * height)
            } else 0f
        }

    val bmiFormatted: String
        get() = formatter.format(bmi)
}