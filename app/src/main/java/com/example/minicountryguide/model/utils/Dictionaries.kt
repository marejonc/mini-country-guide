package com.example.minicountryguide.model.utils

object Dictionaries {
    fun findPolishSide(englishSide: String): String {
        return when (englishSide) {
            "right" -> "Right"
            "left" -> "Left"
            else -> ""
        }
    }
}