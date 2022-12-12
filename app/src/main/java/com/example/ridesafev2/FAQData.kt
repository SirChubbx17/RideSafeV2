package com.example.ridesafev2

data class FAQData(
    val question: String,
    val content: String,
    var isExpandable: Boolean = false
)
