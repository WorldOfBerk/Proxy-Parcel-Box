package de.thk.gm.fddw.proxyparcelbox.controllers

import de.thk.gm.fddw.proxyparcelbox.models.User
import de.thk.gm.fddw.proxyparcelbox.services.UsersService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import de.thk.gm.fddw.proxyparcelbox.dtos.UserDTO
import jakarta.validation.Valid

@Controller
class UsersController (
    private val usersService: UsersService
) {

    @GetMapping("/login")
    fun login(): String {
        return "users/login"
    }

    @PostMapping("/login")
    fun createUser(@Valid userDTO: UserDTO): String {
        var user = User()
        user.email = userDTO.email
        user.name = userDTO.name
        usersService.save(user)
        return "redirect:/"
    }
}