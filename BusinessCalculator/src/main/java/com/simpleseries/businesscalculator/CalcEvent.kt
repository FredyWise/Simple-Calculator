package com.simpleseries.businesscalculator

sealed class CalcEvent {
    data class Number (val number: String): CalcEvent()
    object Clear: CalcEvent()
    object Delete: CalcEvent()
    object DecimalPoint: CalcEvent()
    object Percent: CalcEvent()
    object Calculate: CalcEvent()
    data class Operation(val operation: CalcOperation): CalcEvent()
}

