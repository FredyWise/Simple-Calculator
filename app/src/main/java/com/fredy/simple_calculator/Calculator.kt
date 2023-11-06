package com.fredy.simple_calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Calculator(
    state: CalcState,
    modifier: Modifier = Modifier,
    btnSpacing: Dp = 10.dp,
    onAction: (CalcAction) -> Unit,
    calculatorShape: Shape = MaterialTheme.shapes.small,
    calcTextStyle: TextStyle = MaterialTheme.typography.displayLarge,
    calcBtnStyle: TextStyle = MaterialTheme.typography.headlineSmall,
    textColor: Color = MaterialTheme.colorScheme.onSecondary,
    textBackgroundColor: Color = MaterialTheme.colorScheme.secondary,
    buttonTextColor: Color = MaterialTheme.colorScheme.onSecondary,
    numberButtonBackgroundColor: Color = MaterialTheme.colorScheme.secondary,
    operandButtonBackgroundColor: Color = MaterialTheme.colorScheme.primary,
    borderColor: Color = Color.Black,
    buttonAspectRatio: Float = 1f

) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(
                    Alignment.BottomCenter
                ),
            verticalArrangement = Arrangement.spacedBy(
                btnSpacing
            ),

            ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .background(
                        textBackgroundColor,
                        calculatorShape
                    )
                    .border(1.dp, color = borderColor, calculatorShape)
                    .fillMaxWidth()
                    .padding(
                        vertical = 5.dp
                    )
                    .padding(horizontal = 25.dp)
                    .weight(1f),
                style = calcTextStyle,
                color = textColor,
                maxLines = 1
            )
            // First row (AC - Del - /)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    btnSpacing
                )
            ) {
                CalcButton(btnSymbol = "AC",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            operandButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(2.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Clear)
                    })
                CalcButton(btnSymbol = "%",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            operandButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Percent)
                    })
                CalcButton(btnSymbol = "Del",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            operandButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Delete)
                    })
                CalcButton(btnSymbol = "/",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            operandButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Operation(
                                CalcOperation.Divide
                            )
                        )
                    })
            }
            // Second row (7, 8, 9, x)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    btnSpacing
                )
            ) {
                CalcButton(btnSymbol = "7",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            numberButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Number(
                                "7"
                            )
                        )
                    })
                CalcButton(btnSymbol = "8",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            numberButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Number(
                                "8"
                            )
                        )
                    })
                CalcButton(btnSymbol = "9",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            numberButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Number(
                                "9"
                            )
                        )
                    })
                CalcButton(btnSymbol = "x",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            operandButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Operation(
                                CalcOperation.Multiply
                            )
                        )
                    })
            }
            // Third row (4, 5, 6, -)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    btnSpacing
                )
            ) {
                CalcButton(btnSymbol = "4",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            numberButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Number(
                                "4"
                            )
                        )
                    })
                CalcButton(btnSymbol = "5",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            numberButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Number(
                                "5"
                            )
                        )
                    })
                CalcButton(btnSymbol = "6",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            numberButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Number(
                                "6"
                            )
                        )
                    })
                CalcButton(btnSymbol = "-",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            operandButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Operation(
                                CalcOperation.Substract
                            )
                        )
                    })
            }
            // Fourth row (1, 2, 3, +)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    btnSpacing
                )
            ) {
                CalcButton(btnSymbol = "1",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            numberButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Number(
                                "1"
                            )
                        )
                    })
                CalcButton(btnSymbol = "2",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            numberButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Number(
                                "2"
                            )
                        )
                    })
                CalcButton(btnSymbol = "3",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            numberButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Number(
                                "3"
                            )
                        )
                    })
                CalcButton(btnSymbol = "+",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            operandButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Operation(
                                CalcOperation.Add
                            )
                        )
                    })
            }
            // Fifth row (0, decimal, equals)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    btnSpacing
                )
            ) {
                CalcButton(btnSymbol = "0",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            numberButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Number(
                                "0"
                            )
                        )
                    })
                CalcButton(btnSymbol = "00",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            numberButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcAction.Number(
                                "00"
                            )
                        )
                    })
                CalcButton(btnSymbol = ".",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            numberButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.DecimalPoint)
                    })
                CalcButton(btnSymbol = "=",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            operandButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(1.dp, color = borderColor, calculatorShape)
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(CalcAction.Calculate)
                    })
            }
        }
    }
}


@Composable
fun CalcButton(
    btnSymbol: String,
    modifier: Modifier,
    btnStyle: TextStyle,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    onClick: () -> Unit,
) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .clickable {
                onClick()
            }
            .then(modifier)) {
        Text(
            text = btnSymbol,
            style = btnStyle,
            color = textColor
        )
    }
}



