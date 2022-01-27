package com.example.minicountryguide.model.utils

object Dictionaries {

    fun findPolishContinentName(englishName: String): String {
        val polishName = when(englishName) {
            "Asia" -> "Azja"
            "Africa" -> "Afryka"
            "South America" -> "Ameryka Południowa"
            "North America" -> "Ameryka Północna"
            "Europe" -> "Europa"
            "Oceania" -> "Australia i Oceania"
            "Antarctica" -> "Antarktyda"
            else -> {
                ""
            }
        }
        return polishName
    }

    fun findPolishSide(englishSide: String): String {
        return when (englishSide) {
            "right" -> "Prawa"
            "left" -> "Lewa"
            else -> ""
        }
    }
}