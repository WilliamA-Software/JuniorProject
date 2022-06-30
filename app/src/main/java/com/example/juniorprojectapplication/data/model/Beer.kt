package com.example.juniorprojectapplication.data.model

data class Beer (
    val id: Long = 0,
    var name: String,
    var tagline: String = "",
    var description: String = "",
    var imageUrl: String = "",
    var ph: Double = 0.0,
    var attenuationLevel: Double = 0.0,
    var abv: Double = 0.0
)