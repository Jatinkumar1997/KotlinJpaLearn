package com.example.kotlinjpalearn.repository

import com.example.kotlinjpalearn.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface OrderRepository : JpaRepository<Order, Long> {

    @Query("select count(o),o.customerId from Order o where o.customerId in :customerIds group by o.customerId order by count(o) desc")
    fun getOrdersCountByCustomer(customerIds: List<Long>): List<Any>
}