package de.thk.gm.fddw.proxyparcelbox.dtos

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Size
import java.util.*

class UserDTO {
    @Email
    @Size(min = 5, max = 50)
    var email: String = ""
    @Size(min = 2, max = 50)
    var name: String = ""
}