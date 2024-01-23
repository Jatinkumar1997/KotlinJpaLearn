package com.example.kotlinjpalearn.service

import com.example.kotlinjpalearn.entity.CustomersOrder
import com.example.kotlinjpalearn.entity.Order
import com.example.kotlinjpalearn.repository.OrderRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class OrderService(private val orderRepository: OrderRepository) {

    fun fetchCountOfOrders(): List<Any> {
        return orderRepository.getOrdersCountByCustomer(listOf(1,2,4))
    }
    fun saveOrders(){
        orderRepository.save(Order(LocalDate.now(),1,101))
        orderRepository.save(Order(LocalDate.now(),1,102))
        orderRepository.save(Order(LocalDate.now(),1,103))
        orderRepository.save(Order(LocalDate.now(),2,104))
        orderRepository.save(Order(LocalDate.now(),4,105))
    }
}