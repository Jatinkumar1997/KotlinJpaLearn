package com.example.kotlinjpalearn.repository

import com.example.kotlinjpalearn.entity.Sale
import org.springframework.data.mongodb.repository.MongoRepository

interface SaleRepository : MongoRepository<Sale, Long> {

}