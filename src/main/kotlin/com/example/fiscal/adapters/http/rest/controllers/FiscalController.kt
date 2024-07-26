package com.example.fiscal.adapters.http.rest.controllers

import com.example.fiscal.adapters.http.rest.dtos.request.FiscalRequest
import com.example.fiscal.adapters.http.rest.dtos.response.FiscalResponse
import com.example.fiscal.core.services.FiscalService
import jakarta.validation.Valid
import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/nfce")
class FiscalController(private val fiscalService: FiscalService, private val reenviarNotasJob: Job, private val jobLauncher: JobLauncher) {

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createNFCE(@RequestBody @Valid fiscalRequest: FiscalRequest): FiscalResponse {
        fiscalService.createNFCE(fiscalRequest)
            .let { return FiscalResponse(it) }
    }

    @PostMapping("/cancel/{ref}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun cancelNFCE(@PathVariable ref: String) {
        fiscalService.cancelNFCE(ref)
    }

    @PostMapping(value = ["/startJobOne"])
    fun startJob(@RequestParam(required = true) jobParameter: Long?): ResponseEntity<String> {
        jobLauncher.run(reenviarNotasJob, JobParametersBuilder().toJobParameters())

        return ResponseEntity.accepted().body("Job successfully started.")
    }
}