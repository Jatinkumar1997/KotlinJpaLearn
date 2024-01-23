package com.example.kotlinjpalearn.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "orders")
class Order(
    val orderDate: LocalDate,
    val customerId: Long,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val orderId: Long? = null
)