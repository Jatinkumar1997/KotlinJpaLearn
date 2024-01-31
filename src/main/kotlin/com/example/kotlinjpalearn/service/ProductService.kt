package com.example.kotlinjpalearn.service

import com.example.kotlinjpalearn.entity.Product
import com.example.kotlinjpalearn.entity.ProductSummary
import com.example.kotlinjpalearn.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepo: ProductRepository) {

    fun getAllProducts(): List<Product> = productRepo.findAll()

    fun getProductWithPriceMoreThan50(): List<Product> {
        return productRepo.findProductByProductPriceGreaterThan(50.0)
    }

    fun getProductSummaryForProductsWithPriceLessThan50(): List<ProductSummary> {
        return productRepo.findByProductPriceLessThan(50.0)
    }

    fun saveProduct(product: Product): Product {
        return productRepo.save(product)
    }


}