package de.thk.gm.fddw.proxyparcelbox.services

import de.thk.gm.fddw.proxyparcelbox.models.Chat
import de.thk.gm.fddw.proxyparcelbox.repositories.ChatsRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ChatsServiceImpl (private val chatsRepository: ChatsRepository) : ChatsService {
    override fun findById(id: String): Chat? {
        return chatsRepository.findByIdOrNull(id)
    }

    override fun findAll(): List<Chat> {
        return chatsRepository.findAll().toList()
    }

    override fun findByEmail(email: String): Chat? {
        return chatsRepository.findByEmail(email)
    }

    override fun save(chat: Chat) {
        chatsRepository.save(chat)


    }

    override fun delete(chat: Chat) {
        chatsRepository.delete(chat)
    }

    override fun getSubscribers(id: String): List<String> {
                val chat = chatsRepository.findByTrackingnumber(id)
                return chat?.subscribedChat?.toList() ?: emptyList()
    }
}