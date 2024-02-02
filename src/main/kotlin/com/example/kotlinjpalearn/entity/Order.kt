package com.example.kotlinjpalearn.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate


@Document("orders")
class Order(
    val orderDate: LocalDate,
    val customerId: Long,
    @Id val orderId: Long? = null
)