package com.example.myapplication.kotlin

fun main(args: Array<String>) {

    //Immutable Collection 값을 변경 할 수 없는 Collection -> .set 이 없음..
    //List 중복을 허용 한다
    println("=====List=====")
    val numberList = listOf<Int>(1, 2, 3, 3)
    println(numberList)
    println(numberList.get(0))
    println(numberList[0])

    //Set -> 중복을 허용다 하지 않는다 , 순서가 없다
    println("=====Set=====")
    val numberSet = setOf<Int>(1, 2, 3, 3, 3)
    println(numberSet)
    numberSet.forEach {
        println(it)
    }

    //Map -> Key, Value 방식으로 관리한다
    println("=====Map=====")
    val numberMap = mapOf<String, Int>("one" to 1, "two" to 2)
    println(numberMap)
    println(numberMap.get("one"))

    println()
    //Mutable Collection 값을 변경 할 수 있는 Collection
    println("=====Mutable List=====")
    val mNumberList = mutableListOf<Int>(1, 2, 3)
    println(mNumberList)
    mNumberList.add(3, 5)
    println(mNumberList)

    println("=====Mutable Set=====")
    val mNumberSet = mutableSetOf<Int>(1, 2, 3, 3, 3)
    println(mNumberSet)
    mNumberSet.add(10)
    println(mNumberSet)

    println("=====Mutable Map=====")
    val mNumberMap = mutableMapOf<String, Int>("one" to 1)
    println(mNumberMap)
    mNumberMap.put("two", 2)
    println(mNumberMap)
}