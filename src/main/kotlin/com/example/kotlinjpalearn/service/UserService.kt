package com.example.kotlinjpalearn.service

import com.example.kotlinjpalearn.entity.User
import com.example.kotlinjpalearn.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class UserService(private val userRepo:UserRepository) {
    fun findAllUsers():List<User>{
        val users = userRepo.findAll()
        users.forEach { user -> println(user.userName) }
        return users
    }

    fun addUser(){
        val user1 = User(1,"jatin19","Jatin","Kumar","testing@Sa",LocalDate.of(1997,3,19))
        val user2 = User(2,"test19","Testing","Kumar","Kotlin+jpa fresher",LocalDate.of(2000,2,19))
        userRepo.save(user1)
        userRepo.save(user2)
    }
}