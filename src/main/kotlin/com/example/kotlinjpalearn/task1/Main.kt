package com.example.kotlinjpalearn.task1

import com.example.kotlinjpalearn.task1.htmlDsl.HtmlElement
import com.example.kotlinjpalearn.task1.htmlDsl.HtmlTag
import kotlinx.coroutines.*
import kotlin.time.measureTime

suspend fun main() {
    ///////////////////////**Extension Functions:**////////////////////
    fun List<Int>.findSum(): Int {
        return this.reduce { acc, i -> acc + i }
    }

    val numbers = listOf(1, 2, 4, 5, 11)
    println("Sum of numbers ${numbers.findSum()}")

    //////////////////////// **Data Classes:** //////////////////////////

    val person1 = Person("Jatin", 26, "test@test")
    val person2 = Person("Rohan", 29, "test@test")
    val person3 = Person("Piyush", 34, "test@test")
    val person4 = Person("Aakash", 31, "test@test")
    //  `filter` function to find persons older than 30
    val personsList = mutableListOf(person1, person2, person3, person4)
    personsList.filter { person -> person.age > 30 }.forEach { p -> println("Older than 30 : ${p.name}") }

    // mapper method to convert from one object to another
    fun Person.mapper() = PersonDetails(personInfo = "$name $age $email")

    println("Person 1 details : ${person1.mapper().personInfo}")

    ///////////////////////// **Coroutines:** //////////////////////////////////////

    val timeTaken = measureTime {
        val coroutineTask = CoroutineScope(Dispatchers.IO).async {
            delayFun()
        }
        println(coroutineTask.await())
    }
    println("Total time taken in coroutine: $timeTaken")

    ////////////////////////// **Higher-Order Functions:** //////////////////////

    fun filterList(lambda: (List<String>, Int) -> List<String>): List<String> {
        return lambda(listOf("abcd", "testing"), 5)
    }

    val lambda = { list: List<String>, length: Int -> list.filter { l -> l.length > length } }

    println("Filtered list of strings : ${filterList(lambda)}")

    /////////////////////////// **Generics: ** ////////////////////////////

    fun <T> swap(list: MutableList<T>, index1: Int, index2: Int) {
        val temp = list[index1]
        list[index1] = list[index2]
        list[index2] = temp
    }

    val numbersList = mutableListOf(1, 2, 3, 4, 5)
    swap(numbersList, 3, 4)
    println("After swap List: $numbersList")

    val stringsList = mutableListOf("ab", "cd", "ef")
    swap(stringsList, 1, 2)
    println("After swap List : $stringsList")

    ///////////////////////////////// **Sealed Classes:** /////////////////////

    fun area(shape: Shape) {
        when (shape) {
            is Shape.Circle -> println("Area of circle : ${shape.calculateArea()}")
            is Shape.Rectangle -> println("Area of rectangle : ${shape.calculateArea()}")
        }
    }
    area(Shape.Circle(5.0))
    area(Shape.Rectangle(5.0, 6.0))

    ///////////////////////////// **Type-Safe Builders:** ////////////////////


    val html = html {
        tag("title") {
            text("Title of html page")
        }
        tag("body") {
            text("Body...")
        }
    }

    println(html.render())

    //////////////////////////// **Functional Programming:** //////////////////////

    val listOfNumbers = listOf(2, 3, 4, 5)
    val sum = listOfNumbers.filter { num -> num % 2 == 0 }.map { num -> num * num }.reduce { acc, num -> acc + num }
    println("Sum of squares of even numbers from list : $sum")
}

suspend fun delayFun(): String {
    delay(2000L)
    return "Task completed"
}

fun html(configure: HtmlTag.Builder.() -> Unit): HtmlElement {
    val builder = HtmlTag.Builder("html")
    builder.configure()
    return builder.build()
}

fun HtmlTag.Builder.addChild(child: HtmlElement) {
    children = children.plus(child)
}

fun HtmlTag.Builder.text(text: String) = addChild { text }

fun HtmlTag.Builder.tag(name: String, configure: HtmlTag.Builder.() -> Unit) =
    addChild(HtmlTag.Builder(name).apply(configure).build())