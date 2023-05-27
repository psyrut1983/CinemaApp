package com.example.cinema

data class movies(
    val entries: Int,
    val next: String,
    val page: Int,
    val results: List<Result>
)