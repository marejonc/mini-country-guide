package com.example.minicountryguide.model.entities

data class Country(
    val translations: Translation,
    val name: Name,
    val flags: Flag,
    val continents: List<String>,
    val capital: List<String>,
    val cca2: String,
    val cca3: String,
    val borders: List<String>,
    val area: Double,
    val population: Int,
    val timezones: List<String>,
    val car: Car
)