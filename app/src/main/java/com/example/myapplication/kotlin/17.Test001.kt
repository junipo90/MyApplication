package com.example.myapplication.kotlin

fun main(args: Array<String>) {
    first()
    println()
    println(second(80))
    println()
    println(third(52))
    println()
    gugudan()
}

fun first() {
    val mList1 = mutableListOf<Int>()
    val mList2 = mutableListOf<Boolean>()
    for (i in 0..9) {
        mList1.add(i)
    }
    for (item in mList1) {
        if (item % 2 == 0) {
            mList2.add(true)
        } else {
            mList2.add(false)
        }
    }
    println(mList1)
    println(mList2)
}

fun second(score: Int): Char {
    return when (score) {
        in 80..90 -> {
            'A'
        }
        in 70..79 -> {
            'B'
        }
        in 60..69 -> {
            'C'
        }
        else -> {
            'F'
        }
    }
}

fun third(number: Int): Int {
    val num1: Int = number / 10
    val num2: Int = number % 10
    return num1 + num2
}

fun gugudan() {
    for (i in 2..9) {
        for (j in 1..9) {
            println("$i X $j = " + i * j)
        }
    }
}