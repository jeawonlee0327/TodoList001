package com.teamsparta.todolist.domain.repository

import com.teamsparta.todolist.domain.model.Card
import org.springframework.data.jpa.repository.JpaRepository



interface CardRepository: JpaRepository<Card, Long> {
}