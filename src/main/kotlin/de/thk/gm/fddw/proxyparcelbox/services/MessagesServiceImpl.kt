package de.thk.gm.fddw.proxyparcelbox.services

import de.thk.gm.fddw.proxyparcelbox.controllers.ChatsController
import de.thk.gm.fddw.proxyparcelbox.models.Chat
import de.thk.gm.fddw.proxyparcelbox.models.Message
import de.thk.gm.fddw.proxyparcelbox.repositories.ChatsRepository
import de.thk.gm.fddw.proxyparcelbox.repositories.MessagesRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MessagesServiceImpl (private val messagesRepository: MessagesRepository, private val chatsRepository: ChatsRepository) : MessagesService{

    override fun save(message: Message): Message {
        return messagesRepository.save(message)
    }

    override fun getMessagesByChatRoom(chat: Chat): List<Message> {
        val messages = messagesRepository.findByChat(chat)
        return messages
    }

    fun createAndSaveMessage(id: String, sender: String, text: String, email: String) {

        val chat = chatsRepository.findByTrackingnumber(id)
        val message = Message()
        message.chat = chat
        message.sender = sender
        message.text = text
        message.email = email

        save(message)
    }
}