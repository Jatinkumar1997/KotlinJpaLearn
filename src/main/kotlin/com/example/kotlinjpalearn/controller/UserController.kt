package com.example.kotlinjpalearn.controller

import com.example.kotlinjpalearn.entity.*
import com.example.kotlinjpalearn.service.*
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService,
    private val productService: ProductService,
    private val orderService: OrderService,
    private val studentService: StudentService,
    private val courseService: CourseService,
    private val projectService: ProjectService,
    private val employeeService: EmployeeService
) {

    @GetMapping("/users")
    fun getUsers(): List<User> {
        userService.addUser()
        return userService.findAllUsers()
    }

    @GetMapping("/products")
    fun getProducts(): List<Product> {
        return productService.getProductWithPriceMoreThan50()
    }

    @GetMapping("/orders/count")
    fun getOrdersCount(): List<Any> {
        orderService.saveOrders()
        return orderService.fetchCountOfOrders()
    }

    @GetMapping("/student")
    fun getStudentsInCourse(@RequestParam courseName: String): Set<Student> {
        courseService.addCourse(Course("Java begin", 1))
        courseService.addCourse(Course("Kotlin begin", 2))
        courseService.addCourse(Course("Python begin", 3))
        studentService.enrollStudentToCourse(1, "Jatin Kumar")
        studentService.enrollStudentToCourse(1, "Himanshu")
        return courseService.getStudentsByCourse(courseName)
    }

    @PostMapping("/student")
    fun enrollStudent(@RequestBody enrollStudent: EnrollStudentBody): Student? {
        courseService.addCourse(Course("Java begin", 1))
        courseService.addCourse(Course("Kotlin begin", 2))
        courseService.addCourse(Course("Python begin", 3))
        return studentService.enrollStudentToCourse(enrollStudent.courseId, enrollStudent.studentName)
    }

    @GetMapping("/employee")
    fun getEmployeesInProject(@RequestParam projectId: Long): Set<Employee> {
        employeeService.addEmployee(Employee("jatkumar", "jatin@test.com", null, 1))
        employeeService.addEmployee(Employee("testUser", "testing@test.com", null, 2))
        projectService.addProject(Project("XYZ", "testing", mutableSetOf(), null, 1))
        employeeService.assignProject(1, 1)
        return projectService.fetchEmployeesByProject(projectId)
    }


}