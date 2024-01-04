package com.teamsparta.todolist.domain.controller


import com.teamsparta.todolist.domain.dto.CardRequest
import com.teamsparta.todolist.domain.dto.CardResponse
import com.teamsparta.todolist.domain.service.CardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/cards")
@RestController
class CardController(
    private val cardService: CardService
) {


    @PostMapping
    fun createCard(@RequestBody cardRequest: CardRequest): ResponseEntity<CardResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(cardService.createCard(cardRequest))
    }
}
