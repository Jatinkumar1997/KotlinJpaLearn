package com.example.kotlinjpalearn.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "users")
data class User (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "user_name", unique = true, nullable = false)
    val userName: String,
    @Column(name = "first_name", nullable = false)
    val firstName: String,
    @Column(name = "last_name", nullable = false)
    val lastName: String,
    @Column(name = "email_address", nullable = false)
    val emailId: String,
    @Column(name = "day_of_birth", nullable = false)
    val dayOfBirth: LocalDate
)