package com.example.kotlinjpalearn.entity

import com.example.kotlinjpalearn.enums.ProductCategory
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("products")
class Product(
    val productName: String,
    val productPrice: Double,
    val productCategory: ProductCategory,
    @Id val productId: Long?
)