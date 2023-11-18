package com.fredy.simple_calculator

sealed class CalcEvent {
    data class Number (val number: String): CalcEvent()
    object Clear: CalcEvent()
    object Delete: CalcEvent()
    object DecimalPoint: CalcEvent()
    object Percent: CalcEvent()
    object Calculate: CalcEvent()
    data class Operation(val operation: CalcOperation): CalcEvent()
}

sealed class CalcOperation (val symbol: String) {

    object Add: CalcOperation("+")
    object Substract: CalcOperation("-")
    object Multiply: CalcOperation("x")
    object Divide: CalcOperation("/")
}

data class CalcState(
    val number1: String = "0",
    val number2: String = "",
    val operation: CalcOperation? = null
)