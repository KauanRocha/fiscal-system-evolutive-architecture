package com.example.fiscal.core.services

import com.example.fiscal.adapters.http.rest.dtos.request.FiscalRequest
import com.example.fiscal.adapters.http.rest.exceptions.NotFoundEntityException
import com.example.fiscal.adapters.persistence.entities.FiscalEntity
import com.example.fiscal.adapters.persistence.repositories.FiscalRepository
import com.example.fiscal.core.entities.FiscalSituation
import org.springframework.stereotype.Service


@Service
class FiscalService(private val fiscalRepository: FiscalRepository) {

    fun cancelNFCE(ref: String) {
        fiscalRepository.findByRef(ref)
            .orElseThrow { NotFoundEntityException("not-found-document-with-ref-$ref") }
            .let {
                it.status = FiscalSituation.CANCELLED
                fiscalRepository.save(it)
            }

    }

    fun createNFCE(fiscalRequest: FiscalRequest): FiscalEntity {
        buildFiscalEntity(fiscalRequest).let {
            return fiscalRepository.save(it)
        }
    }

    fun reSendNFCE(nfce: FiscalEntity): FiscalEntity {
        nfce.status = FiscalSituation.ISSUED
        return fiscalRepository.save(nfce)
    }

    private fun buildFiscalEntity(fiscalRequest: FiscalRequest): FiscalEntity {
        return FiscalEntity(null,fiscalRequest.ref, fiscalRequest.payments,
            fiscalRequest.products)
    }
}