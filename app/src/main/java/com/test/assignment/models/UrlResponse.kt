package com.test.assignment.models

data class UrlResponse(
    val archived: Boolean,
    val created_at: String,
    val custom_bitlinks: List<Any>,
    val deeplinks: List<Any>,
    val id: String,
    val link: String,
    val long_url: String,
    val references: References,
    val tags: List<Any>
)