package com.test.assignment.models

data class Event(
    val actor: Actor,
    val created_at: String,
    val id: Int,
    val repo: Repo,
    val type: String
)