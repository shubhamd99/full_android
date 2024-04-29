package com.example.inappupdates.presentation

import androidx.compose.runtime.Composable
import com.example.inappupdates.domain.CalculatorAction

data class CalculatorUiAction(
    val text: String?,
    val highlightLevel: HighlightLevel,
    val action: CalculatorAction,
    val content: @Composable () -> Unit = {}
)

sealed interface HighlightLevel {
    data object Neutral: HighlightLevel
    data object SemiHighlighted: HighlightLevel
    data object Highlighted: HighlightLevel
    data object StronglyHighlighted: HighlightLevel
}