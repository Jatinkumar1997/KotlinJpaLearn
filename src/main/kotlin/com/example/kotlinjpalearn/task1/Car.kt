package com.example.kotlinjpalearn.task1

class Car(private val make:String, private val model:String, private val year:Int) {

    fun printCarDetails(){
        println("Car Details: make: $make , model: $model , year: $year")
    }
}