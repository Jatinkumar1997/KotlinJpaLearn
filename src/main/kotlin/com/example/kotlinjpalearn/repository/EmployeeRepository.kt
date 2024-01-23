package com.example.kotlinjpalearn.repository

import com.example.kotlinjpalearn.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface EmployeeRepository : JpaRepository<Employee, Long> {

    fun getEmployeeByEmployeeId(employeeId: Long): Employee

}