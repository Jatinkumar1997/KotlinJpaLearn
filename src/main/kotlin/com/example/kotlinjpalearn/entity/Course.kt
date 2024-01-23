package com.example.kotlinjpalearn.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
class Course(
    @Column(name = "course_name", unique = true, nullable = false) val courseName: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val courseId: Long? = null,
    @ManyToMany(mappedBy = "enrolledCourses") @JsonIgnore val studentsEnrolled: MutableSet<Student> = mutableSetOf()
) {
    fun addStudent(student: Student) {
        this.studentsEnrolled.add(student)
    }
}