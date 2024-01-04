package com.teamsparta.todolist.domain.service

import com.teamsparta.todolist.domain.dto.CardRequest
import com.teamsparta.todolist.domain.dto.CardResponse


interface CardService {
    fun createCard(request: CardRequest): CardResponse
}