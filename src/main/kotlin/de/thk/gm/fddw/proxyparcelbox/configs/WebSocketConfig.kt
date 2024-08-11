package de.thk.gm.fddw.proxyparcelbox.configs

import de.thk.gm.fddw.proxyparcelbox.websocketsHandlers.ChatHandler
import de.thk.gm.fddw.proxyparcelbox.websocketsHandlers.EchoHandler
import de.thk.gm.fddw.proxyparcelbox.services.ChatsService
import de.thk.gm.fddw.proxyparcelbox.services.MessagesService
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

// Communication between the server and the client
@Configuration
@EnableWebSocket
class WebSocketConfig (val chatsService: ChatsService, val messagesService: MessagesService ) : WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(EchoHandler(),"/echo")
        registry.addHandler(ChatHandler(chatsService, messagesService),"/chat")
    }
}
