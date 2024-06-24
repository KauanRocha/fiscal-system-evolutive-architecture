package com.example.fiscal.core.services

import com.example.fiscal.adapters.http.rest.dtos.request.NFCERequest
import com.example.fiscal.adapters.persistence.entities.FiscalEntity
import com.example.fiscal.adapters.persistence.repositories.FiscalRepository
import com.example.fiscal.core.entities.FiscalSituation
import org.springframework.stereotype.Service


@Service
class FiscalService(private val fiscalRepository: FiscalRepository) {

    fun cancelNFCE(ref: String) {
        fiscalRepository.findByRef(ref)
            .orElseThrow { IllegalArgumentException("not-found-document-with-ref-$ref") }
            .let {
                it.status = FiscalSituation.CANCELLED
                fiscalRepository.save(it)
            }

    }

    fun createNFCE(nfceRequest: NFCERequest): FiscalEntity {
        buildFiscalEntity(nfceRequest).let {
            return fiscalRepository.save(it)
        }
    }

    private fun buildFiscalEntity(nfceRequest: NFCERequest): FiscalEntity {
        return FiscalEntity(null,nfceRequest.ref, nfceRequest.payments,
            nfceRequest.products)
    }
}