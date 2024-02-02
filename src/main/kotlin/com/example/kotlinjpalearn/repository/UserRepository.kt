package com.example.kotlinjpalearn.repository

import com.example.kotlinjpalearn.entity.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, Long> {
    fun findByUserName(userName: String): User?
}