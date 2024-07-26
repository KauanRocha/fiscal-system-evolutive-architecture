package com.example.fiscal.core.services

import com.example.fiscal.adapters.persistence.entities.ProductEntity
import com.example.fiscal.adapters.persistence.repositories.ProductRepository
import com.example.fiscal.core.entities.Product
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun createProduct(product: Product): ProductEntity {
        val entity = ProductEntity(null, product.name, product.unitPrice)
        return productRepository.save(entity)
    }
}
