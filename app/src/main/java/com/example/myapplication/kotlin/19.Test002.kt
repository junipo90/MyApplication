package com.example.myapplication.kotlin

fun main(args: Array<String>) {

    var calc: Calc = Calc(10, 3)
    calc.add()
    calc.sub()
    calc.mul()
    calc.div()

    println()

    var clac2: Calc2 = Calc2()
    println(clac2.plus(1, 2, 3, 4, 5))
    println(clac2.minus(1, 2, 3, 4, 5))
    println(clac2.multiply(1, 2, 3, 4, 5))
    println(clac2.divide(1, 2, 3, 4, 5))

    println()

    var calc3: Calc3 = Calc3(5)
    val calc3_result = calc3.plus(5).minus(3).multiply(3).divide(7).initialValue
    println(calc3_result)


}

class Calc {
    var num1: Int
    var num2: Int

    constructor(num1: Int, num2: Int) {
        this.num1 = num1
        this.num2 = num2
    }

    fun add() {
        println("addition = ${num1 + num2}")
    }

    fun sub() {
        println("subtraction = ${num1 - num2}")
    }

    fun mul() {
        println("multiply = ${num1 * num2}")
    }

    fun div() {
        println("division = ${num1 / num2} , remainder = ${num1 % num2}")
    }
}

class Calc2 {
    fun plus(vararg numbers: Int): Int {
        var result: Int = 0
        numbers.forEach {
            result += it
        }
        return result
    }

    fun minus(vararg numbers: Int): Int {
        var result: Int = numbers[0]
        for (i in 1 until  numbers.size) {
            result -= numbers[i]
        }
        return result
    }

    fun multiply(vararg numbers: Int): Int {
        var result: Int = 1
        numbers.forEachIndexed { index, item ->
            if (numbers[index] != 0) {
                result *= item
            }
        }
        return result
    }

    fun divide(vararg numbers: Int): Int {
        var result: Int = numbers[0]
        for ((index, item) in numbers.withIndex()) {
            if (index != 0 && item != 0) {
                result /= item
            }
        }
        return result
    }
}

class Calc3(var initialValue:Int){
    fun plus(num:Int):Calc3{
        var result:Int = this.initialValue
        result += num
        return Calc3(result)
    }
    fun minus(num:Int):Calc3{
        var result:Int = this.initialValue
        result -= num
        return Calc3(result)
    }
    fun multiply(num:Int):Calc3{
        var result:Int = this.initialValue
        result *= num
        return Calc3(result)
    }
    fun divide(num:Int):Calc3{
        var result:Int = this.initialValue
        result /= num
        return Calc3(result)
    }
}


