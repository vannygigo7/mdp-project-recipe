package com.sangvaleap.foodiepal_culinarycompanion.model

import java.io.Serializable

data class User(
    val firstName: String,
    val lastName: String,
    val username: String,
    val password: String
): Serializable