package com.example.kotlinjpalearn.service

import com.example.kotlinjpalearn.entity.Employee
import com.example.kotlinjpalearn.entity.Project
import com.example.kotlinjpalearn.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class ProjectService(private val projectRepository: ProjectRepository) {

    fun fetchEmployeesByProject(projectId: Long): MutableSet<Employee> {
        return projectRepository.findProjectByProjectId(projectId)?.projectEmployees ?: mutableSetOf()
    }

    fun addProject(project: Project): Project {
        return projectRepository.save(project)
    }

}