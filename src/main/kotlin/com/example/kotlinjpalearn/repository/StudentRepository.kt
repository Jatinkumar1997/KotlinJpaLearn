package com.example.kotlinjpalearn.repository

import com.example.kotlinjpalearn.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long> {}