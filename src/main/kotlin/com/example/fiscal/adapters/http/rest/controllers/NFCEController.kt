package com.example.fiscal.adapters.http.rest.controllers

import com.example.fiscal.adapters.http.rest.dtos.request.NFCERequest
import com.example.fiscal.adapters.http.rest.dtos.response.NFCEResponse
import com.example.fiscal.core.services.FiscalService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/nfce")
class NFCEController(private val fiscalService: FiscalService) {

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createNFCE(nfceRequest: NFCERequest): NFCEResponse {
        fiscalService.createNFCE(nfceRequest)
            .let { return NFCEResponse(it) }
    }

    @PostMapping("/cancel/{ref}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun cancelNFCE(@PathVariable ref: String) {
        fiscalService.cancelNFCE(ref)
    }
}