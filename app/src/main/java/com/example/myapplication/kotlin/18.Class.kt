package com.example.myapplication.kotlin

fun main(args: Array<String>) {

    val Car: Car = Car("v8", "big")
    val SuperCar: SuperCar = SuperCar("good engine", "big", "white")

    val runnableCar: RunnableCar = RunnableCar("simple engine", "short body")
    runnableCar.ride()
    runnableCar.navi("산본")
    runnableCar.drive()

    println()

    val runnableCar2: RunnableCar2 = RunnableCar2("power engine", "long body")
    println(runnableCar2.engine)
    println(runnableCar2.body)

    println()

    val testClass: TestClass = TestClass()
    testClass.test(1)
    testClass.test(1,2)
}

//클래스 만드는 방법(1)
class Car(var engine: String, var body: String) {

}

//클래스 만드는 방법(2)
class SuperCar {
    var engine: String
    var body: String
    var door: String

    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}

//클래스 만드는 방법(3)
class Car1(var engine: String, var body: String) {
    var door: String = ""

    constructor(engine: String, body: String, door: String) : this(engine, body) {
        this.door = door
    }
}

//클래스 만드는 방법(4)
class Car2 {
    var engine: String = ""
    var body: String = ""
    var door: String = ""


    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }
}

//클래스 만드는 방법(5) 함수 사용
class RunnableCar(engine: String, body: String) {
    fun ride() {
        println("차에 탑승합니다")
    }

    fun navi(destination: String) {
        println("$destination 으로 목적지가 설정 되었습니다")
    }

    fun drive() {
        println("차가 달립니다")
    }
}

//클래스 만드는 방법(6) 멤버 변수 접근, init 메서드
class RunnableCar2 {
    var engine: String
    var body: String

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    init {
        println("RunnableCar2 인스턴스가 만들어졌습니다")
    }

    fun ride() {
        println("차에 탑승합니다")
    }

    fun navi(destination: String) {
        println("$destination 으로 목적지가 설정 되었습니다")
    }

    fun drive() {
        println("차가 달립니다")
    }
}

//오버로딩
class TestClass{
    fun test(a:Int){
        println("매개변수가 하나인 test 함수")
    }

    fun test(a:Int, b:Int){
        println("매개변수가 두개인 test 함수")
    }
}