package com.example.myapplication.kotlin

fun main(args: Array<String>) {
    val group1 = arrayOf<Int>(1, 2, 3, 4, 5)
    val num1 = group1.get(0)
//    val num2 = group1.get(100) //인덱스 오류

    group1.set(0, 100)
//    group1.set(100, 100) //인덱스 오류

    // Array 의 Bounds
    // -> 배열이 처음 생성 될 때 결정 된다.

    // Array 를 만드는 방법(3)
    val a1 = intArrayOf(1,2,3)
    val a2 = charArrayOf('b', 'c')
    val a3 = doubleArrayOf(1.23, 100.123)
    val a4 = booleanArrayOf(true, false, true)

    // Array 를 만드는 방법(4) -> lambda 를 사용하는 방법
    val a5 = Array(5,{0})
    for (i in a5) {
        println(i)
    }

    println()
    val a6 = Array(3,{1;2;3})
    for (i in a6) {
        println(i)
    }
}