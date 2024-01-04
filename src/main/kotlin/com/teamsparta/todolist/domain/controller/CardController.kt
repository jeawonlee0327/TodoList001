package com.teamsparta.todolist.domain.controller


import com.teamsparta.todolist.domain.dto.CardResponse
import com.teamsparta.todolist.domain.dto.CardRequest
import com.teamsparta.todolist.domain.service.CardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @GetMapping("/{cardId}")
    fun getCard(@PathVariable cardId: Long): ResponseEntity<CardResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cardService.getCardById(cardId))
    }

    @GetMapping
    fun getCardList(): ResponseEntity<List<CardResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cardService.getCardList())
    }

    @PutMapping("/update/{cardId}")
    fun updateCard(
        @PathVariable cardId: Long,
        @RequestBody cardRequest: CardRequest
    ): ResponseEntity<CardResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cardService.updateCard(cardId, cardRequest))
    }

    @DeleteMapping("/delete/{cardId}")
    fun deleteCourse(@PathVariable cardId: Long): ResponseEntity<Unit> {
        cardService.deleteCard(cardId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }
}

