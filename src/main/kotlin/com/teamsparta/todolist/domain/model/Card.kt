package com.teamsparta.todolist.domain.model

import com.teamsparta.todolist.domain.dto.CardResponse
import jakarta.persistence.*
import java.time.OffsetDateTime


@Entity
@Table(name = "card")
class Card(

    @Column(name = "title")
    var title: String,

    @Column(name = "description")
    var description: String,

    @Column(name = "created_at")
    var createdAt: OffsetDateTime,

    @Column(name = "writer")
    var writer: String


) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun Card.toResponse(): CardResponse {
    return CardResponse(
        id = id!!,
        title = title,
        description = description,
        writer = writer,
        createdAt = createdAt
    )
}