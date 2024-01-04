package com.teamsparta.todolist.domain.dto

import java.time.OffsetDateTime

data class CardResponse(
    val id: Long,
    val title: String,
    val description: String,
    val createdAt: OffsetDateTime,
    val writer: String

)
