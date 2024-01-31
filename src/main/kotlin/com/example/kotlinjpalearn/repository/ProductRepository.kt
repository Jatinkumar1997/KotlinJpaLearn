package com.example.kotlinjpalearn.repository

import com.example.kotlinjpalearn.entity.Product
import com.example.kotlinjpalearn.entity.ProductSummary
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {

    fun findProductByProductPriceGreaterThan(productPrice: Double): List<Product>
    fun findByProductPriceLessThan(productPrice: Double): List<ProductSummary>
}