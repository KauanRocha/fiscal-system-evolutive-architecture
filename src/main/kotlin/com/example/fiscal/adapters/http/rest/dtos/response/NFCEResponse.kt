package com.example.fiscal.adapters.http.rest.dtos.response

import com.example.fiscal.adapters.persistence.entities.FiscalEntity
import java.time.LocalDateTime

data class NFCEResponse(val id: String, val ref: String, val issuanceDate: LocalDateTime) {
    constructor(fiscalEntity: FiscalEntity) : this(
        id = fiscalEntity.id.toString(),
        ref = fiscalEntity.ref,
        issuanceDate = fiscalEntity.issuanceDate ?: LocalDateTime.now()
    )
}
