package com.fredy.simplebusinesscalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Calculator(
    modifier: Modifier = Modifier,
    btnSpacing: Dp = 10.dp,
    calculatorShape: Shape = MaterialTheme.shapes.medium,
    calcTextStyle: TextStyle = MaterialTheme.typography.displaySmall,
    textColor: Color = MaterialTheme.colorScheme.onSecondary,
    maxLine: Int = 1,
    textBackgroundColor: Color = MaterialTheme.colorScheme.secondary,
    calcBtnStyle: TextStyle = MaterialTheme.typography.headlineSmall,
    buttonTextColor: Color = MaterialTheme.colorScheme.onSecondary,
    numberButtonBackgroundColor: Color = MaterialTheme.colorScheme.secondary,
    operandButtonBackgroundColor: Color = MaterialTheme.colorScheme.primary,
    borderColor: Color = Color.Black,
    buttonAspectRatio: Float = 1f,
    calculatorViewModel: CalculatorViewModel = viewModel(),
    leadingObject: @Composable () -> Unit = {},
) {
    val state: CalcState = calculatorViewModel.state
    val onAction: (CalcEvent) -> Unit = calculatorViewModel::onAction
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
            Row(
                modifier = Modifier
                    .background(
                        textBackgroundColor,
                        calculatorShape
                    )
                    .border(
                        1.dp,
                        color = borderColor,
                        calculatorShape
                    )
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(btnSpacing),
                verticalAlignment = Alignment.Bottom
            ) {
                leadingObject()
                Text(
                    modifier = Modifier
                        .weight(0.75f)
                        .padding(end = 20.dp, start = 8.dp),
                    text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                    textAlign = TextAlign.End,
                    style = calcTextStyle,
                    color = textColor,
                    maxLines = maxLine
                )
            }
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
                        .border(
                            2.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvent.Clear)
                    })
                CalcButton(btnSymbol = "%",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            operandButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvent.Percent)
                    })
                CalcButton(btnSymbol = "Del",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            operandButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvent.Delete)
                    })
                CalcButton(btnSymbol = "/",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            operandButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Operation(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Number(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Number(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Number(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Operation(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Number(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Number(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Number(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Operation(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Number(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Number(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Number(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Operation(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Number(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(
                            CalcEvent.Number(
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
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvent.DecimalPoint)
                    })
                CalcButton(btnSymbol = "=",
                    btnStyle = calcBtnStyle,
                    textColor = buttonTextColor,
                    modifier = Modifier
                        .background(
                            operandButtonBackgroundColor,
                            calculatorShape
                        )
                        .border(
                            1.dp,
                            color = borderColor,
                            calculatorShape
                        )
                        .aspectRatio(
                            buttonAspectRatio
                        )
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvent.Calculate)
                    })
            }
        }
    }
}



