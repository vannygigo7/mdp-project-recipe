package com.sangvaleap.foodiepal_culinarycompanion.model

import java.io.Serializable

data class Recipe(
    val name: String,
    val ingredients: String,
    val instruction: String,
    val imageUrl: String
): Serializable