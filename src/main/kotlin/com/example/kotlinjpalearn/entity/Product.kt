package com.example.kotlinjpalearn.entity

import jakarta.persistence.*

@Entity
class Product(
    @Column(name = "name", unique = true, nullable = false) val productName: String,
    @Column(name = "price", nullable = false) val productPrice: Double,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val productId: Long? = null
)