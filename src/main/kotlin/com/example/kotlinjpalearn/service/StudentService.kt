package com.example.kotlinjpalearn.service

import com.example.kotlinjpalearn.entity.Course
import com.example.kotlinjpalearn.entity.Student
import com.example.kotlinjpalearn.repository.CourseRepository
import com.example.kotlinjpalearn.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(private val studentRepository: StudentRepository, private val courseRepository: CourseRepository) {

    fun enrollStudentToCourse(courseId: Long, studentName: String): Student? {
        val course = courseRepository.findById(courseId)
        if (course.isPresent) {
            val student = Student(studentName)
            course.get().addStudent(student)
            student.addCourse(course.get())
            return studentRepository.save(student)
        }
        throw Exception("Course Not found")
    }

    fun fetchAllStudents(): List<Student> {
        return studentRepository.findAll()
    }
}