package de.thk.gm.fddw.proxyparcelbox.services

import de.thk.gm.fddw.proxyparcelbox.models.User
import java.util.*

interface UsersService {
    fun findById(id: UUID): User?
    fun findAll(): List<User>
    fun findByEmail(email: String): User?
    fun save(user: User)
    fun delete(user: User)
}