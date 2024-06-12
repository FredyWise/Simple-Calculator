package com.fredy.simplebusinesscalculator

data class CalcState(
    val number1: String = "0",
    val number2: String = "",
    val operation: CalcOperation? = null,
    val MAX_NUMBER_LENGTH: Int = 13
)