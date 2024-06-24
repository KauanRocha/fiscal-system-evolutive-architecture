package com.example.fiscal.adapters.persistence.entities

import com.example.fiscal.core.entities.FiscalSituation
import com.example.fiscal.core.entities.Payment
import com.example.fiscal.core.entities.Product
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("nfces")
data class FiscalEntity(
    @Id val id: String? = null,
    val ref: String,
    val payments: List<Payment>,
    val products: List<Product>,
    val issuanceDate: LocalDateTime ?= LocalDateTime.now(),
    var status: FiscalSituation? = FiscalSituation.ISSUED
)