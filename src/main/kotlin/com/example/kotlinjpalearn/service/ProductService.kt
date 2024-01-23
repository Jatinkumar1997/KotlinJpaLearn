package com.example.kotlinjpalearn.service

import com.example.kotlinjpalearn.entity.Product
import com.example.kotlinjpalearn.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepo: ProductRepository) {

    fun getAllProducts(): List<Product> = productRepo.findAll()

    fun getProductWithPriceMoreThan50(): List<Product> {
        return productRepo.findProductByProductPriceGreaterThan(50.0)
    }

}