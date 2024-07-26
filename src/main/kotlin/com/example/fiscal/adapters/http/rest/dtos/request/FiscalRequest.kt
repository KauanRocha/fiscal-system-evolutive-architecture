package com.example.fiscal.adapters.http.rest.dtos.request

import com.example.fiscal.core.entities.Payment
import com.example.fiscal.core.entities.Product
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class FiscalRequest(
    @NotNull val ref: String,
    @NotNull val cnpj: String,
    @NotNull @NotEmpty  val products: List<Product>,
    @NotNull @NotEmpty val payments: List<Payment>
)

