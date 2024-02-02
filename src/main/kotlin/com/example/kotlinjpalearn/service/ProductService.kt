package com.example.kotlinjpalearn.service

import com.example.kotlinjpalearn.entity.Product
import com.example.kotlinjpalearn.enums.ProductCategory
import com.example.kotlinjpalearn.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepo: ProductRepository) {

    fun getAllProducts(): MutableList<Product> = productRepo.findAll()
    fun getProductsForCategoryAndPriceLessThan(productCategory: ProductCategory, price: Double): Set<Product> {
        return productRepo.findByProductCategoryAndProductPriceLessThan(productCategory, price)
    }

    fun addProduct(product: Product): Product {
        return productRepo.save(product)
    }

}