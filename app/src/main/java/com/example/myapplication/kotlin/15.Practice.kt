package com.example.myapplication.kotlin

fun main(args: Array<String>) {
    val mList = mutableListOf<Int>(1, 2, 3)
    println(mList)
    mList.add(5)
    println(mList)
    mList.add(0, 100)
    println(mList)
    mList.set(0, 200)
    println(mList)
    mList.remove(200)
    println(mList)
    mList.removeAt(0)
    println(mList)

    println()
    val mSet = mutableSetOf<Int>(1, 2, 3, 3, 3)
    mSet.add(3)
    println(mSet)
    mSet.add(100)
    println(mSet)
    mSet.remove(3)
    mSet.remove(200)
    println(mSet)

    println()
    val mMap = mutableMapOf<String, Int>("one" to 1)
    println(mMap)
    mMap.put("two", 2)
    println(mMap)
    mMap.replace("two", 222)
    println(mMap)
    mMap.clear()
    println(mMap)




}