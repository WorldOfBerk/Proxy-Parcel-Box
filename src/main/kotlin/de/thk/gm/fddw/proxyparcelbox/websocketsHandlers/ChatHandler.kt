package de.thk.gm.fddw.proxyparcelbox.websocketsHandlers

import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import de.thk.gm.fddw.proxyparcelbox.models.Message
import de.thk.gm.fddw.proxyparcelbox.services.ChatsService
import de.thk.gm.fddw.proxyparcelbox.services.MessagesService
import java.util.*
import kotlin.collections.ArrayList

class ChatHandler(val chatsService: ChatsService, val messagesService: MessagesService) : TextWebSocketHandler() {

    private val sessions: MutableMap<String, MutableList<WebSocketSession>> = mutableMapOf()

    override fun afterConnectionEstablished(session: WebSocketSession) {
        super.afterConnectionEstablished(session)
        val trackingNumber = getTrackingNumber(session)
        if (trackingNumber != null) {
            sessions.computeIfAbsent(trackingNumber) { mutableListOf() }.add(session)
        }
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val trackingNumber = getTrackingNumber(session)
        if (trackingNumber != null) {
            val chatMessage = Message()
            chatMessage.text = message.payload
            chatMessage.createdAt = Date()
            chatMessage.sender = session.id
            messagesService.save(chatMessage)

            sessions[trackingNumber]?.forEach { chatSession ->
                if (chatSession.id != session.id) {
                    chatSession.sendMessage(message)
                }
            }
        }
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        val trackingNumber = getTrackingNumber(session)
        if (trackingNumber != null) {
            sessions[trackingNumber]?.removeIf { it.id == session.id }
        }
    }

    private fun getTrackingNumber(session: WebSocketSession): String? {
        // Assume trackingNumber is passed as a query parameter
        val uri = session.uri
        val query = uri?.query
        return query?.split("&")?.find { it.startsWith("trackingNumber=") }?.split("=")?.get(1)
    }
}
