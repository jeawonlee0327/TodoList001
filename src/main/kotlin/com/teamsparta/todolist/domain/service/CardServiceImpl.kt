package com.teamsparta.todolist.domain.service

import com.teamsparta.todolist.domain.dto.CardRequest
import com.teamsparta.todolist.domain.dto.CardResponse
import com.teamsparta.todolist.domain.model.Card
import com.teamsparta.todolist.domain.model.toResponse
import com.teamsparta.todolist.domain.repository.CardRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CardServiceImpl(
    private val cardRepository: CardRepository
) : CardService {
    @Transactional
    override fun createCard(request: CardRequest): CardResponse {
        return cardRepository.save(
            Card(
                title = request.title,
                description = request.description,
                createdAt = request.createdAt,
                writer = request.writer
            )
        )
            .toResponse()

    }
}