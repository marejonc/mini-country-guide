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
            else -> {
                "Antarktyda"
            }
        }
        return polishName
    }

    fun findPolishSide(englishSide: String): String {
        return if(englishSide == "right") "Prawa"
        else "Lewa"
    }
}