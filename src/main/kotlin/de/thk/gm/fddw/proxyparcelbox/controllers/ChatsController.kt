package de.thk.gm.fddw.proxyparcelbox.controllers

import org.springframework.ui.Model
import de.thk.gm.fddw.proxyparcelbox.models.Chat
import de.thk.gm.fddw.proxyparcelbox.models.Message
import de.thk.gm.fddw.proxyparcelbox.models.User
import de.thk.gm.fddw.proxyparcelbox.services.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.util.*

@Controller
class ChatsController(
    private val chatsRestController: ChatsRestController,
    private val chatsService: ChatsService,
    private val messagesService: MessagesService,
    private val messagesServiceImpl: MessagesServiceImpl,
    private val usersService: UsersService,
) {

    // DTO for creating a chat
    data class ChatRequest(
        var trackingNumber: String,
        var email: String,
        var emailUser: String,
        var subscribedChat : MutableList<String> = mutableListOf()
    )

    @GetMapping("/")
    fun getIndex(model: Model): String {
        return "index"
    }

    // QR code for chat
    @GetMapping("/chats/{id}")
    fun getChatQR(@PathVariable("id") trackingNumber: String, model: Model, redirectAttributes: RedirectAttributes): String {
        val chat: Chat? = chatsService.findById(trackingNumber)
        model.addAttribute("chat", chat)
        return "chats/showChat"
    }

    // Chat page
   @GetMapping("/messages/{trackingnumber}")
    fun getChatByTrackingNumber(@PathVariable("trackingnumber") trackingNumber: String, model: Model): String {
        val chat: Chat? = chatsService.findById(trackingNumber)
        model.addAttribute("chat", chat)
        val user: User? = usersService.findByEmail(chat?.emailUser!!)
        model.addAttribute("user", user)

        if(chat == null) throw ResponseStatusException(HttpStatus.NOT_FOUND)
        val messages = messagesService.getMessagesByChatRoom(chat)  //List of messages

        model.addAttribute("messages", messages)
        return "chats/showMessages"
    }

    @GetMapping("/aboutUs")
    fun getAboutUsPage(model: Model): String {
        return "headerLinks/aboutUs"
    }

    @GetMapping("/support")
    fun getSupportPage(model: Model): String {
        return "headerLinks/support"
    }

    // Return List of messages
    @GetMapping("/messages/{trackingnumber}/chat")
    @ResponseBody
    fun getChatMessages(@PathVariable("trackingnumber") trackingNumber: String): List<Message> {
        val chat : Chat? = chatsService.findById(trackingNumber)
        return if (chat != null) {
            messagesService.getMessagesByChatRoom(chat)
        } else {
            emptyList()
        }
    }

    // Return List of subscribers
    @GetMapping("/chats/subscribers/{trackingNumber}")
    @ResponseBody
    fun getChatSubscribers(@PathVariable trackingNumber: String): ResponseEntity<List<String>> {
        val subscribers = chatsService.getSubscribers(trackingNumber)
        return ResponseEntity.ok(subscribers)
    }

    // Save message
    @PostMapping("/messages/{trackingnumber}")
    fun saveMessages(@PathVariable("trackingnumber") trackingNumber: String, @RequestBody message: Message): ResponseEntity<Message> {
        val chat = chatsService.findById(trackingNumber)
        return if (chat == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            message.chat = chat
            messagesServiceImpl.createAndSaveMessage(trackingNumber, message.sender, message.text, message.email)
            ResponseEntity.ok().build()
        }
    }

    // Create chat
    @PostMapping("/chats")
    fun createChat(@ModelAttribute chatRequest: ChatRequest, model: Model) : String {
        val chat = Chat(chatRequest.trackingNumber)
        chat.email = chatRequest.email
        chat.emailUser = chatRequest.emailUser

        chatsRestController.saveChat(chat)

        return "redirect:/chats/${chat.id}"
    }
}