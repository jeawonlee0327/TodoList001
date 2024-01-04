package com.teamsparta.todolist.domain.service


import com.teamsparta.todolist.domain.Exception.dto.ModelNotFoundException
import com.teamsparta.todolist.domain.dto.CardRequest
import com.teamsparta.todolist.domain.dto.CardResponse
import com.teamsparta.todolist.domain.model.Card
import com.teamsparta.todolist.domain.model.toResponse
import com.teamsparta.todolist.domain.repository.CardRepository
import org.springframework.data.repository.findByIdOrNull
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

    override fun getCardById(id: Long): CardResponse {
        val card = cardRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Card", id)
        return card.toResponse()
    }

    @Transactional
    override fun updateCard(id: Long, request: CardRequest): CardResponse {
        val card = cardRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Card", id)
        val (title, description) = request
        card.title = title
        card.description = description
        return cardRepository.save(card)
            .toResponse()
    }

    @Transactional
    override fun deleteCard(id: Long) {
        val card = cardRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Card", id)
        cardRepository.delete(card)
    }

    override fun getCardList(): List<CardResponse> {
        return cardRepository.findAll().map {
            it.toResponse()
        }
    }
}