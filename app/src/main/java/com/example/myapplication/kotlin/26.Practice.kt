package com.example.myapplication.kotlin

fun main(args: Array<String>) {
    val superNight: SuperNight = SuperNight(100, 100, 5)
    val superMonster: SuperMonster = SuperMonster(200, 4)

    superNight.attack(superMonster)
    superMonster.attack(superNight)
}

open class Night100(private var hp: Int, private var power: Int) {

    open fun attack(monster: Monster100) {
        monster.defense(power)
    }

    open fun defense(power: Int) {
        hp -= power
        if (hp > 0) {
            heal()
            println("기사의 남은 체력은 $hp 입니다")
        } else {
            println("기사가 죽었습니다")
        }
    }

    private fun heal() {
        hp += 3
    }

}

open class Monster100(private var hp: Int, private var power: Int) {

    open fun attack(night: Night100) {
        night.defense(power)
    }

    open fun defense(power: Int) {
        hp -= power
        if (hp > 0) {
            println("몬스터의 남은 체력은 $hp 입니다")
        } else {
            println("몬스터의 죽었습니다")
        }
    }
}

class SuperNight(hp: Int, private var mp: Int, private var power: Int) : Night100(hp, power) {
    override fun attack(monster: Monster100) {
        super.attack(monster)
        if (mp > 0) {
            mp -= 10
            println("마법 공격, 남은 mp = $mp")
            monster.defense(power + 1)
        }
    }

    override fun defense(power: Int) {
        super.defense(power)
    }
}

class SuperMonster(hp: Int, power: Int) : Monster100(hp, power) {
    override fun attack(night: Night100) {
        super.attack(night)
    }

    override fun defense(power: Int) {
        super.defense(power)
    }
}