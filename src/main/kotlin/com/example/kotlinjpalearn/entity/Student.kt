package com.example.kotlinjpalearn.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
class Student(
    @Column(name = "student_name", unique = true, nullable = false) val studentName: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val studentId: Long? = null,
    @ManyToMany @JoinTable(
        name = "student_course",
        joinColumns = [JoinColumn(name = "student_id")],
        inverseJoinColumns = [JoinColumn(name = "course_id")]
    ) @JsonIgnore val enrolledCourses: MutableSet<Course> = mutableSetOf()
) {
    fun addCourse(course: Course) {
        enrolledCourses.add(course)
    }
}