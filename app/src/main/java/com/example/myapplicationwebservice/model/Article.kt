package com.example.myapplicationwebservice.model

import java.io.Serializable

data class Article(
    var id: Int,
    var userid: Int,
    var title: String,
    var content: String
)
