package com.example.kotlinjpalearn.service

import com.example.kotlinjpalearn.entity.Order
import com.example.kotlinjpalearn.repository.OrderRepository
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregate
import org.springframework.data.mongodb.core.aggregation.Aggregation.*
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class OrderService(val mongoTemplate: MongoTemplate, private val orderRepository: OrderRepository) {

    fun fetchCountOfOrders(): List<Any> {
        val aggregation = newAggregation(
            group("customerId").count().`as`("count"), sort(Sort.Direction.DESC, "count")
        )
        val res: AggregationResults<Any> = mongoTemplate.aggregate(aggregation, "orders")
        return res.toList()
    }

    fun saveOrders() {
        orderRepository.save(Order(LocalDate.now(), 1, 101))
        orderRepository.save(Order(LocalDate.now(), 1, 102))
        orderRepository.save(Order(LocalDate.now(), 1, 103))
        orderRepository.save(Order(LocalDate.now(), 2, 104))
        orderRepository.save(Order(LocalDate.now(), 4, 105))
    }
}