package com.fredy.simplebusinesscalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CalculatorViewModel(
    initValue: String = "0",
    val MAX_NUMBER_LENGTH: Int = 13
): ViewModel() {
    var state by mutableStateOf(CalcState(number1 = initValue))

    fun onAction(event: CalcEvent) {
        when (event) {
            is CalcEvent.Number -> enterNumber(
                event.number
            )
            is CalcEvent.DecimalPoint -> enterDecimal()
            is CalcEvent.Clear -> state = CalcState()
            is CalcEvent.Operation -> enterOperation(
                event.operation
            )
            is CalcEvent.Calculate -> performCalculation()
            is CalcEvent.Delete -> performDeletion()
            is CalcEvent.Percent -> performPercent()
        }

    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.length == 1 && state.number1 != "0" -> state = state.copy(
                number1 = "0"
            )

            state.number1.isNotBlank() && state.number1 != "0" -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalcOperation.Add -> number1 + number2
                is CalcOperation.Substract -> number1 - number2
                is CalcOperation.Multiply -> number1 * number2
                is CalcOperation.Divide -> number1 / number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(
                    10
                ), number2 = "", operation = null
            )
            prettier()
        }
    }

    private fun enterOperation(operation: CalcOperation) {
        if (state.number1.isNotBlank() && state.number2.isBlank()) {
            state = state.copy(operation = operation)
        } else if (state.number1.isNotBlank() && state.number2.isNotBlank()) {
            performCalculation()
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(
                "."
            ) && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    private fun performPercent() {
        if (state.operation == null && !state.number1.contains(
                "%"
            ) && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = (state.number1.toDouble() / 100).toString()
            )
            prettier()
            return
        }
        if (!state.number2.contains("%") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = (state.number2.toDouble() / 100).toString()
            )
            prettier()
        }
    }

    private fun prettier() {
        if (state.operation == null && state.number1.endsWith(
                ".0"
            ) && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1.dropLast(2)
            )
            return
        }
        if (state.number2.endsWith(".0") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2.dropLast(2)
            )
        }
    }

    private fun enterNumber(number: String) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUMBER_LENGTH) {
                return
            }
            if (state.number1 == "0") {
                state = state.copy(
                    number1 = ""
                )
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= MAX_NUMBER_LENGTH) {
            return
        }
        if (state.number2 == "0") {
            state = state.copy(
                number2 = ""
            )
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

}


@Suppress("UNCHECKED_CAST")
class CalculatorViewModelFactory(private val initValue: String, private val MAX_NUMBER_LENGTH: Int): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return CalculatorViewModel(initValue = initValue, MAX_NUMBER_LENGTH = MAX_NUMBER_LENGTH) as T
    }
}


