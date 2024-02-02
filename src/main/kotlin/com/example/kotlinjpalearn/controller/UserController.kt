package com.example.kotlinjpalearn.controller

import com.example.kotlinjpalearn.entity.*
import com.example.kotlinjpalearn.enums.ProductCategory
import com.example.kotlinjpalearn.service.*
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService,
    private val productService: ProductService,
    private val orderService: OrderService,
    private val saleService: SaleService
) {

    @GetMapping("/users")
    fun getUsers(): List<User> {
        userService.addUser()
        return userService.findAllUsers()
    }

    @GetMapping("/products")
    fun getProducts(@RequestParam productCategory: ProductCategory, @RequestParam price: Double): Set<Product> {
        productService.addProduct(Product("Samsung TV", 450.0, ProductCategory.ELECTRONICS, 1))
        return productService.getProductsForCategoryAndPriceLessThan(productCategory, price)
    }

    @GetMapping("/orders/count")
    fun getOrdersCount(): List<Any> {
        return orderService.fetchCountOfOrders()
    }

    @GetMapping("/sale/count")
    fun getSalesCount(): List<Any> {
        return saleService.getSalesDataForMonth()
    }

}