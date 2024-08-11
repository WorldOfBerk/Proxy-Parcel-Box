package de.thk.gm.fddw.proxyparcelbox.services

import de.thk.gm.fddw.proxyparcelbox.models.Chat
import de.thk.gm.fddw.proxyparcelbox.models.Message
import org.springframework.stereotype.Service
import java.util.*

@Service
interface MessagesService {
    fun save(message: Message): Message
    fun getMessagesByChatRoom(chat: Chat): List<Message>
}