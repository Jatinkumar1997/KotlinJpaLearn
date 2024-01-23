package com.example.kotlinjpalearn.repository

import com.example.kotlinjpalearn.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {

    fun findProductByProductPriceGreaterThan(productPrice: Double): List<Product>
}