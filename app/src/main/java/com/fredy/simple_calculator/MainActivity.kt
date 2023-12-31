package com.fredy.simple_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fredy.simple_calculator.ui.theme.SimpleCalculatorTheme

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Calculator_Screen()
            }
        }
    }
}

@Composable
fun Calculator_Screen(calculatorViewModel: CalculatorViewModel = viewModel()) {
    Surface(
        color = Color.Black,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Calculator(
            state = calculatorViewModel.state,
            onAction = calculatorViewModel::onAction
        )
    }
}