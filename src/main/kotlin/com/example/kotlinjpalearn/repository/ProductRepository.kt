package com.example.kotlinjpalearn.repository

import com.example.kotlinjpalearn.entity.Product
import com.example.kotlinjpalearn.enums.ProductCategory
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<Product, Long> {

    fun findByProductCategoryAndProductPriceLessThan(
        productCategory: ProductCategory, productPrice: Double
    ): Set<Product>
}