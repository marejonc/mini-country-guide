package com.example.minicountryguide.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class CountryLocal(
    @PrimaryKey
    @ColumnInfo(name = "alpha3")
    val cca3: String,
    @ColumnInfo(name = "alpha2")
    val cca2: String,
    @ColumnInfo(name = "polish_common_name")
    val polishCommonName: String,
    @ColumnInfo(name = "polish_official_name")
    val polishOfficialName: String,
    @ColumnInfo(name = "english_common_name")
    val englishCommonName: String,
    @ColumnInfo(name = "english_official_name")
    val englishOfficialName: String,
    @ColumnInfo(name = "continent")
    val continent: String,
    @ColumnInfo(name = "capital")
    val capital: String,
    @ColumnInfo(name = "neighbours")
    val neighbours: String,
    @ColumnInfo(name = "area")
    val area: Double,
    @ColumnInfo(name = "population")
    val population: Int,
    @ColumnInfo(name = "timezones")
    val timezones: String,
    @ColumnInfo(name = "car_side")
    val carSide: String,
    @ColumnInfo(name = "car_code")
    val carCode: String
)