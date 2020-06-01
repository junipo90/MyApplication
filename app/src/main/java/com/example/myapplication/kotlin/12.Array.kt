package com.example.myapplication.kotlin

fun main(args: Array<String>) {

    //베열을 생성하는 방법(1)
    var number1: Int = 10
    var group1 = arrayOf<Int>(1, 2, 3, 4, 5)
    println(group1 is Array)

    //배열을 생성하는 방법(2)
    var number2 = 10 // 변수를 선언 할 때 값 타입을 명시 하지 않으면, 대입 되는 값을 보고 변수가 선언 된다.
    //배열은 타입을 명시 하지 않으면, 여러가지 타입이 들어가는 배열이 만들어진다.
    var group2 = arrayOf(1, 2, 3.5, "hello")
    //배열에서 값을 꺼내는 방법(1)
    val test1 = group1.get(0)
    println(test1)
    //배열에서 값을 꺼내는 방법(2)
    val test2 = group1[0]
    println(test2)

    //배열에서 값을 바꾸는 방법(1)
    group1.set(0, 100)
    println(group1[0])

    //배열에서 값을 바꾸는 방법(2)
    group1[0] = 200
    println(group1[0])
}