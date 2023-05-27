package com.example.cinema

data class TitleType(
    val __typename: String,
    val id: String,
    val isEpisode: Boolean,
    val isSeries: Boolean,
    val text: String
)