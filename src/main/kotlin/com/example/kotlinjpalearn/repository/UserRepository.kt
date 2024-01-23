package com.example.kotlinjpalearn.repository

import com.example.kotlinjpalearn.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findUserByUserName(userName: String): User?
}