package com.example.kotlinjpalearn.task1.dependencyInjection

class InjectServiceImpl : InjectService {
    override fun injectMe() {
        println("hello from injectService impl")
    }
}