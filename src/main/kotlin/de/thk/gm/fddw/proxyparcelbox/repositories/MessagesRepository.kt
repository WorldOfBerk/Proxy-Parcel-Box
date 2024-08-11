package de.thk.gm.fddw.proxyparcelbox.repositories

import de.thk.gm.fddw.proxyparcelbox.models.Chat
import de.thk.gm.fddw.proxyparcelbox.models.Message
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MessagesRepository : CrudRepository<Message, UUID> {
    fun findByChat(chat: Chat): List<Message>
}