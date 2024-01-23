package com.example.kotlinjpalearn.service

import com.example.kotlinjpalearn.entity.Course
import com.example.kotlinjpalearn.entity.Student
import com.example.kotlinjpalearn.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val courseRepository: CourseRepository) {

    fun getStudentsByCourse(courseName: String): Set<Student> {
        return courseRepository.findCourseByCourseName(courseName)?.studentsEnrolled ?: emptySet()
    }

    fun addCourse(course: Course): Course {
        return courseRepository.save(course)
    }

    fun getAllCourses(): List<Course> {
        return courseRepository.findAll()
    }
}