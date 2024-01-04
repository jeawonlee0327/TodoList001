package com.teamsparta.todolist.domain.service


import com.teamsparta.todolist.domain.dto.CardRequest
import com.teamsparta.todolist.domain.dto.CardResponse


interface CardService {
    fun createCard(request: CardRequest): CardResponse

    fun getCardList(): List<CardResponse>

    fun getCardById(id: Long): CardResponse

    fun updateCard(id: Long, request: CardRequest): CardResponse

    fun deleteCard(id: Long)

}