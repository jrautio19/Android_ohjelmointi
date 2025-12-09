package com.example.painoindeksi.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.painoindeksi.R
import com.example.painoindeksi.viewmodels.BmiViewModel

@Composable
fun Bmi(modifier: Modifier = Modifier, bmiViewModel: BmiViewModel = viewModel()) {

    Column (
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text (
            text = stringResource(R.string.body_mass_index),
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = bmiViewModel.heightInput,
            onValueChange = { bmiViewModel.heightInput = it.replace(',', '.') },
            label = { Text(stringResource(R.string.height)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = bmiViewModel.weightInput,
            onValueChange = { bmiViewModel.weightInput = it.replace(',', '.') },
            label = { Text(stringResource(R.string.weight)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text (
            text = stringResource(R.string.body_mass_index_is, bmiViewModel.bmiFormatted),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
