package com.example.fiscal.adapters.persistence.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("products")
data class ProductEntity(
    @Id val id: String? = null,
    val name: String,
    val unitPrice: Double,
)