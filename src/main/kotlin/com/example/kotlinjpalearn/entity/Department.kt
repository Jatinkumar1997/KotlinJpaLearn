package com.example.kotlinjpalearn.entity

import jakarta.persistence.*

@Entity
class Department(
    @Column(name = "name", unique = true, nullable = false) val departmentName: String,
    @Column(name = "description", unique = true, nullable = false) val departmentDescription: String,
    @OneToMany(mappedBy = "department") val departmentProjects: Set<Project>,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val departmentId: Long? = null
)