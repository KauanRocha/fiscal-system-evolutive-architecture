package com.example.fiscal.adapters.persistence.repositories

import com.example.fiscal.adapters.persistence.entities.FiscalEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FiscalRepository : MongoRepository<FiscalEntity, String> {

     fun findByRef(ref: String): Optional<FiscalEntity>;
}