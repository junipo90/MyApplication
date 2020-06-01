package com.example.myapplication

import java.io.Serializable

class Post(
    val owner: String? = null,
    val content: String? = null,
    val image: String? = null
) : Serializable