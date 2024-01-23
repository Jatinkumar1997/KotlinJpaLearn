package com.example.kotlinjpalearn.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
class Employee(
    @Column(name = "user_name", unique = true, nullable = false) val userName: String,
    @Column(name = "email", nullable = false) val employeeEmail: String,
    @ManyToOne var project: Project? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val employeeId: Long? = null
) {
    fun assignProject(project: Project) {
        this.project = project
    }
}
