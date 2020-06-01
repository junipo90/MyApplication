package com.example.myapplication.kotlin
fun main(args: Array<String>) {
    val value: Int = 3
    when (value) {
        1 -> {
            println("value is 1")
        }
        2 -> {
            println("value is 2")
        }
        3 -> {
            println("value is 3")
        }
        else -> {
            println("I do not know value")
        }
    }

    val value2: Int = when (value) {
        1 -> 10
        2 -> 20
        3 -> 30
        else -> 100
    }

    println(value2)

    val value3: Boolean? = null
    when (value3) {
        true -> println("value3 is true")
        false -> println("value3 is false")
        null -> println("value3 is null")
    }

    val value4: Int = 10
    when (value4) {
        is Int -> println("value4 is Int")
        else -> println("value4 is not Int")
    }

    val value5: Int = 87
    when (value5) {
        in 60..70 -> {
            println("value5 is 60-70")
        }
        in 70..80 -> {
            println("value5 is 70-80")
        }
        in 80..90 -> {
            println("value5 is 80-90")
        }
    }
}