package de.thk.gm.fddw.proxyparcelbox.services

import de.thk.gm.fddw.proxyparcelbox.models.User
import de.thk.gm.fddw.proxyparcelbox.repositories.UsersRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsersServiceImpl (private val usersRepository: UsersRepository) : UsersService {
    override fun findById(id: UUID): User? {
        return usersRepository.findByIdOrNull(id)
    }

    override fun findAll(): List<User> {
        return usersRepository.findAll().toList()
    }

    override fun findByEmail(email: String): User? {
        return usersRepository.findByEmail(email)
    }

    override fun save(user: User) {
        usersRepository.save(user)
    }

    override fun delete(user: User) {
        usersRepository.delete(user)
    }
}