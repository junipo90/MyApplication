package com.example.myapplication.kotlin

fun plusThree(first: Int, second: Int, third: Int): Int {
    return first + second + third
}

fun minusThree(first: Int, second: Int, third: Int) = first - second - third

fun multiplyThree(first: Int = 1, second: Int = 1, third: Int = 1): Int {
    return first * second * third
}

//내부 함수
fun showMyPlus(first: Int, second: Int): Int {
    println(first)
    println(second)

    fun plus(first: Int, second: Int): Int {
        return first + second
    }
    return plus(first, second)
}


fun main(args: Array<String>) {
    val result = plusThree(10, 20, 30)
    println(result)
    val result2 = minusThree(30, 5, 5)
    println(result2)
    val result3 = multiplyThree(2, 2, 2)
    println(result3)
    val result4 = multiplyThree()
    println(result4)

    //내부 함수
    println()
    val result5 = showMyPlus(4, 5)
    println(result5)
}