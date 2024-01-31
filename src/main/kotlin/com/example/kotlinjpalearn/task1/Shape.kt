package com.example.kotlinjpalearn.task1

import kotlin.math.pow

sealed class Shape {
    class Circle(private var radius: Double) : Shape() {
        fun calculateArea(): Double {
            return Math.PI * radius.pow(2.0)
        }
    }

    class Rectangle(private var length: Double, private var breadth: Double) : Shape() {
        fun calculateArea(): Double {
            return length * breadth
        }
    }
}