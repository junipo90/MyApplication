package com.example.myapplication.kotlin

fun main(args: Array<String>) {
    val a = mutableListOf<Int>(1,2,3,4,5,6,7,8,9,10)

    //반복문 사용하는 방법 (1)
    for(item in a){
        if(item == 5){
            println("item is Five")
        }else{
            println("item is not Five")
        }
    }

    println()
    //반복문 사용하는 방법(2)
    for((index, item) in a.withIndex()){
        println("index : " + index + " , value : " + item)
    }

    println()
    //반복문 사용하는 방법(3)
    a.forEach {
        println(it)
    }

    println()
    //반복문 사용하는 방법(4)
    a.forEach {item ->
        println(item)
    }

    println()
    //반복문 사용하는 방법(5)
    a.forEachIndexed { index, item ->
        println("index : $index , value : $item")
    }

    println()
    //반복문 사용하는 방법(6)
    for(i in 0 until a.size){
        //until 은 마지막을 포한 하지 않는다
        println(a.get(i))
    }

    println()
    //반복문 사용하는 방법(7)
    for(i in 0 until a.size step 2){
        println(a.get(i))
    }

    println()
    //반복문 사용하는 방법(8)
    for(i in a.size - 1 downTo 0){
        println(a.get(i))
    }

    println()
    //반복문 사용하는 방법(9)
    for(i in a.size - 1 downTo 0 step 2){
        println(a.get(i))
    }

    println()
    //반복문 사용하는 방법(10)
    for (i in 0..10){
        // .. -> 마지막을 포함 한다
        println(i)
    }

    println()
    //반복문 사용하는 방법(11)
    var num1: Int = 0
    var num2: Int = 4
    while(num1 < num2){
        num1++
        println("num1 : $num1")
    }

    println()
    num1 = 0
    //반복문 사용하는 방법(12)
    do {
        num1++
        println("num1 : $num1")
    }while (num1 < num2)


}