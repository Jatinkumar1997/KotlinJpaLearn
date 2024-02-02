package com.example.kotlinjpalearn.service

import com.example.kotlinjpalearn.entity.Sale
import com.example.kotlinjpalearn.repository.SaleRepository
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.where
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class SaleService(private val mongoTemplate: MongoTemplate, val saleRepo: SaleRepository) {

    fun getSalesDataForMonth(): List<Any> {

        val aggregation = Aggregation.newAggregation(
            Aggregation.match(
                Criteria.where("saleDate").gte(LocalDate.of(2023, 10, 1))
                    .lt(LocalDate.of(2023, 11, 1))
            ),
            Aggregation.group("productId").sum("quantitySold").`as`("totalItemsSold"),
            Aggregation.sort(Sort.Direction.DESC, "totalItemsSold")
        )
        val res: AggregationResults<Any> = mongoTemplate.aggregate(aggregation, "sales")
        return res.toList()
    }

    fun addSales() {
        val sale1 = Sale(LocalDate.of(2023, 10, 2), 4, 101, 1)
        val sale2 = Sale(LocalDate.of(2023, 10, 10), 11, 102, 2)
        val sale3 = Sale(LocalDate.of(2023, 10, 15), 8, 101, 3)
        val sale4 = Sale(LocalDate.of(2023, 11, 5), 4, 102, 4)
        val sale5 = Sale(LocalDate.of(2023, 12, 7), 4, 101, 5)
        saleRepo.saveAll(listOf(sale1, sale2, sale3, sale4, sale5))
    }

}