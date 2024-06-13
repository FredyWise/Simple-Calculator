package com.simpleseries.businesscalculator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun CalcButton(
    modifier: Modifier,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    btnStyle: TextStyle,
    btnSymbol: String,
    onClick: () -> Unit,
) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.clickable {
                onClick()
            }.then(modifier)) {
        Text(
            text = btnSymbol,
            style = btnStyle,
            color = textColor
        )
    }
}