package de.thk.gm.fddw.proxyparcelbox.controllers

import de.thk.gm.fddw.proxyparcelbox.services.ChatsService
import de.thk.gm.fddw.proxyparcelbox.models.Chat

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.ResponseStatus

import org.springframework.web.bind.annotation.RestController

@RestController
class ChatsRestController (
    private val chatsService: ChatsService
) {

    @PutMapping("/chats")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveChat(chat: Chat): Chat {
        chatsService.save(chat)
        return chat
    }
}