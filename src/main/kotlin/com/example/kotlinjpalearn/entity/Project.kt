package com.example.kotlinjpalearn.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
class Project(
    @Column(name = "name", unique = true, nullable = false) val projectName: String,
    @Column(name = "description", unique = true, nullable = false) val projectDescription: String,
    @OneToMany(mappedBy = "project") val projectEmployees: MutableSet<Employee> = mutableSetOf(),
    @ManyToOne @JsonIgnore var department: Department? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val projectId: Long? = null
) {
    fun addEmployee(employee: Employee) {
        projectEmployees.add(employee)
    }
}