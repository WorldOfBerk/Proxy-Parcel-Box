package de.thk.gm.fddw.proxyparcelbox.repositories

import de.thk.gm.fddw.proxyparcelbox.models.Chat
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ChatsRepository : CrudRepository<Chat, String> {
    fun findByEmail(email: String): Chat?
    fun findByTrackingnumber(trackingNumber : String): Chat?
}