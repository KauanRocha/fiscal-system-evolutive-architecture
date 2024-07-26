package com.example.fiscal.core.entities

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class Product(
    @NotNull
    @Size(min = 1, max = 100)
    val name: String,
    val unitPrice: Double,
    val quantity: Int
)