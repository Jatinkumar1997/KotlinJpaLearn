package com.example.kotlinjpalearn.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

// Created a compound index using multiple fields(userName,email) to reduce the time
// on queries where these fields are required.
@Document("users")
data class User(
    @Id val id: Long? = null,
    @Indexed(name = "username_email_index", unique = true)
    val userName: String,
    val firstName: String,
    val lastName: String,
    @Indexed(name = "username_email_index")
    val emailId: String,
    val dayOfBirth: LocalDate
)
