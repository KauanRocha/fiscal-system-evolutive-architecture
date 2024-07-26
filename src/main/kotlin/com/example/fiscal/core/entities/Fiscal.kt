package com.example.fiscal.core.entities


data class Fiscal(
    val ref: String,
    val payments: List<Payment>,
    val products: List<Product>,
    val issuanceDate: String,
    val status: FiscalSituation
)
