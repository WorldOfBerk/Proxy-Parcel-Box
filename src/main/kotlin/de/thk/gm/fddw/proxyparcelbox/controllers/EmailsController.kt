package de.thk.gm.fddw.proxyparcelbox.controllers

import de.thk.gm.fddw.proxyparcelbox.services.ChatsService
import de.thk.gm.fddw.proxyparcelbox.services.EmailService
import de.thk.gm.fddw.proxyparcelbox.services.ParcelService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class EmailsController (val chatsService: ChatsService, val emailService: EmailService, val parcelService: ParcelService) {

    @GetMapping("/emails/testparcelservice/{trackingnumber}")
    @ResponseBody
    fun testParcelService(@PathVariable trackingnumber : String) : String {
        return parcelService.getEmailByTrackingNumber(trackingnumber)
    }

    @GetMapping("/emails/sendemailform")
    fun sendEmailForm() : String {
        return "emails/sendemailform"
    }

    // Subscribe Chat
    @GetMapping("/emails/subscribe/{trackingnumber}")
    fun subscribeEmail(@PathVariable trackingnumber : String, model: Model) : String {
        val chat = chatsService.findById(trackingnumber)
        model.addAttribute("chat", chat)
        return "emails/subscribe"
    }

    @PostMapping("/emails")
    fun sendEmail(receiver: String, subject: String, message: String) : String {
        emailService.sendSimpleMessage(receiver, subject, message)
        return "redirect:/emails/sendemailform"
    }

    // add email to subscribedChat-List and send confirmation email
    @PostMapping("/emails/subscribe/{trackingnumber}")
    fun subscribe(@PathVariable trackingnumber : String, receiver: String) : String {
        val chat = chatsService.findById(trackingnumber)
        if (chat != null) {
            if (!chat.subscribedChat.contains(receiver)) {
                chat.subscribedChat.add(receiver)
                chatsService.save(chat)
            }
        }
        emailService.sendConfirmationEmail(receiver, trackingnumber)
        return "redirect:/messages/{trackingnumber}"
    }

    // Send email if someone sends a message to a subscribed chat
    @PostMapping("/emails/notify/{trackingnumber}")
    @ResponseBody
    fun notifySubscriber(@PathVariable trackingnumber : String, @RequestParam email: String, @RequestParam message: String): ResponseEntity<String> {
        emailService.sendAbonnementConfirmation(email, trackingnumber, message)
        return ResponseEntity.ok("E-Mail gesendet")
    }
}