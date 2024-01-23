package com.example.kotlinjpalearn.repository

import com.example.kotlinjpalearn.entity.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long> {
    fun findCourseByCourseName(courseName: String): Course?
}