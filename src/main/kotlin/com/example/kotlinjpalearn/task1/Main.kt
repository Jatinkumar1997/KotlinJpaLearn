package com.example.kotlinjpalearn.task1


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    ///////////// **Variable Declaration:** ////////////
    var value = 19.99
    println("Initialised value = $value")
    value = 29.99
    println("Updated value = $value")


    ///////////// **Null Safety:** ////////////
    var nullSafeVar = "I'm null safe"
    var x : String? = "sad"
    x = null

    ///////////////////**String Manipulation:**//////////

    val sentence = "Kotlin is concise and expressive"
    var count = 0
    val vowels = arrayOf('a','e','i','o','u')

    sentence.forEach { c ->
        if (vowels.contains(c.lowercaseChar()))
            count++
    }
    println("Count of vowels = $count")

    /////////////////////// **Collections (List):** /////////////////////////////////

    val langList = mutableListOf("Java","C","Javascript")
    langList.add("Python")
    langList.remove("C")

    langList.forEach { lang-> println(lang) }

    //////////////////////////////////////////////////////////

    val testMutableList = mutableListOf(1,2,3,4)
    val testMutableSet = mutableSetOf(1,2,3,4,5)
    val testMutableMap = mutableMapOf(1 to "test",2 to "testing")

    val testList = listOf(1,2,3,4)
    val testSet = setOf(1,2,3,4)
    val testMap = mapOf(1 to "test",2 to "testing")

    // Add element
    testMutableList.add(5)
    testMutableSet.add(5)
    testMutableMap[3] = "something"
    // remove element
    testMutableList.removeAt(0)
    testMutableSet.remove(1)
    testMutableMap.remove(1)
    // update element
    testMutableList[0] = 6
    testMutableMap[1] = "testChange"

    ///////////////////////// **Classes and Objects:** ////////////////////////////////////

    val myCar = Car("Nissan","Magnite",2023)
    myCar.printCarDetails()

    //////////////////////////// **Lambda Expressions:** ////////////////////////////////

    val list = listOf(5, 10, 15, 21, 25, 32)
    val filteredList = list.filter { e -> e%5==0 }

    println("Filtered List: $filteredList")

    //////////////////////// **Exception Handling:**  /////////////////////////////////////

    try {
        val num = "231"
        num.toInt()
    }catch (ex:NumberFormatException){
        println("Exception: $ex")
    }

    //////////////////////////////////////////////////////////////

    val result = runCatching {
        runCatchTest()
    }
    if(result.isSuccess){
        println("Success")
    }else{
        val exception = result.exceptionOrNull()
        println("Failed due to $exception")
    }
}

fun runCatchTest(){
    throw Exception("Error occurred.")
}