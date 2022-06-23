package com.example.nutralysis2.entities

data class nutrentanalysis(
    var calories: Int,
    val cautions: List<Any>,
    val dietLabels: List<String>,
    val healthLabels: List<String>,
    val ingredients: List<Ingredient>,
    val totalDaily: TotalDaily,
    val totalNutrients: TotalNutrients,
    val totalWeight: Double,
    val uri: String,
    val yield: Double
)