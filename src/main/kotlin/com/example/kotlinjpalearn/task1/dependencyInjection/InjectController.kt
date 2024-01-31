package com.example.kotlinjpalearn.task1.dependencyInjection

class InjectController(private val injectService: InjectService) {
    fun testInjectMethod() {
        injectService.injectMe()
        println("Dependency inject working..")
    }
}