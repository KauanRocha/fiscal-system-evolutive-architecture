package com.example.fiscal.adapters.persistence.repositories

import com.example.fiscal.adapters.persistence.entities.ProductEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : MongoRepository<ProductEntity?, String?>
