package com.example.kotlinjpalearn.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate


@Document("sales")
class Sale(
    val saleDate: LocalDate,
    val quantitySold: Long,
    val productId: Long,
    @Id val saleId: Long? = null
)