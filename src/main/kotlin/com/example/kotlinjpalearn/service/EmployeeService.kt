package com.example.kotlinjpalearn.service

import com.example.kotlinjpalearn.entity.Employee
import com.example.kotlinjpalearn.repository.EmployeeRepository
import com.example.kotlinjpalearn.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository, private val projectRepository: ProjectRepository
) {

    fun addEmployee(employee: Employee): Employee {
        return employeeRepository.save(employee)
    }

    fun assignProject(employeeId: Long, projectId: Long): Employee {
        val employee = employeeRepository.getEmployeeByEmployeeId(employeeId)
        val project = projectRepository.findProjectByProjectId(projectId)
        employee.assignProject(project)
        project.addEmployee(employee)
        projectRepository.save(project)
        return employeeRepository.save(employee)
    }

}