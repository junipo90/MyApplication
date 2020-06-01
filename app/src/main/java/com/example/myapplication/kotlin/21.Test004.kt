package com.example.myapplication.kotlin

fun main(args: Array<String>) {


    var tv: TV = TV()
    tv.power()
    tv.infoTv()
    tv.channel_up()
    tv.infoTv()
    tv.channel_up()
    tv.infoTv()
    tv.channel_up()
    tv.infoTv()
    println()
    tv.channel_down()
    tv.infoTv()
    tv.channel_down()
    tv.infoTv()
    tv.channel_down()
    tv.infoTv()
    tv.plus_channel("tvN")
    tv.plus_channel("JTBC")
    println()
    tv.infoTv()
    tv.channel_up()
    tv.infoTv()
    tv.channel_up()
    tv.infoTv()
    tv.channel_up()
    tv.infoTv()
    tv.channel_up()
    tv.infoTv()
    tv.channel_up()
    tv.infoTv()
    println()
    tv.channel_down()
    tv.infoTv()
    tv.channel_down()
    tv.infoTv()
    tv.channel_down()
    tv.infoTv()
    tv.channel_down()
    tv.infoTv()
    tv.channel_down()
    tv.infoTv()

    println(tv.number++)
    println(tv.number)


}


class TV {
    var on_off: Boolean = false
    var channel = mutableListOf<String>("S", "M", "K")
    var now_channel = channel[0]

    //set, get
    var number = 0
        set(value) {
            field = value
            println("set")
        }
        get() {
            println("get")
            return field
        }

    fun power() {
        this.on_off = !this.on_off
    }

    fun infoTv() {
        println(
            "전원 $on_off\n" +
                    "채널 $now_channel\n" +
                    "전체 채널 $channel"
        )
    }

    fun channel_up() {
        if (channel.indexOf(this.now_channel) == channel.lastIndex) {
            this.now_channel = channel[0]
        } else {
            this.now_channel = channel[channel.indexOf(this.now_channel) + 1]
        }
    }

    fun channel_down() {
        if (channel.indexOf(this.now_channel) == 0) {
            this.now_channel = channel[channel.lastIndex]
        } else {
            this.now_channel = channel[channel.indexOf(this.now_channel) - 1]
        }
    }

    fun plus_channel(channel: String) {
        this.channel.add(channel)
    }
}