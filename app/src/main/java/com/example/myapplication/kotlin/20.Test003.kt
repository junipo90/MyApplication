package com.example.myapplication.kotlin

fun main(args: Array<String>) {
    var person1: Bank = Bank("lee", "19901025")
    person1.info()
    person1.deposit(100000)
    person1.withdraw(20000)
    person1.info()

    println()
}

class Bank {
    var name: String
    var birth: String
    var money: Int = 0

    constructor(name: String, birth: String) {
        this.name = name
        this.birth = birth
    }

    fun deposit(money: Int) {
        this.money += money
        println("잔액은 ${this.money}원 입니다")
    }

    fun withdraw(money: Int) {
        if (money > this.money) {
            println("잔액이 부족")
        } else {
            this.money -= money
        }
        println("잔액은 ${this.money}원 입니다")
    }

    fun info() {
        println("${this.name}님의 생년월일은 ${this.birth}입니다")
        println("잔액은 ${this.money}입니다")
    }
}

//생성자 괄호 안에 val, var 를 생략하면 클래스 메소드에서 접근 불가하고 변수에서 접근 할 수 있
class Account(initialBalance : Int){
    var balance = if(initialBalance >= 0) initialBalance else 0

    fun checkBalance():Int{
        return balance
    }
}