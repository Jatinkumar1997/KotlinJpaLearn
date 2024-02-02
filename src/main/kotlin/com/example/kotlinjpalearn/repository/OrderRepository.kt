package com.example.kotlinjpalearn.repository

import com.example.kotlinjpalearn.entity.Order
import org.springframework.data.mongodb.repository.MongoRepository

interface OrderRepository : MongoRepository<Order, Long> {}