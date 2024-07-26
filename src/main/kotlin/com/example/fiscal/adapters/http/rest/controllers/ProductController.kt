package com.example.fiscal.adapters.http.rest.controllers

import com.example.fiscal.adapters.persistence.entities.ProductEntity
import com.example.fiscal.core.entities.Product
import com.example.fiscal.core.services.ProductService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/product")
class ProductController(private val productService: ProductService) {

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@RequestBody @Valid product: Product): ProductEntity {
        return productService.createProduct(product)
    }
}
