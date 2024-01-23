package com.example.kotlinjpalearn.repository

import com.example.kotlinjpalearn.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long> {

    fun findProjectByProjectId(projectId: Long): Project
}