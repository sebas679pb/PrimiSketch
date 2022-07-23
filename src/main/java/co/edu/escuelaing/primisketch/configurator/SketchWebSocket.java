package co.edu.escuelaing.primisketch.configurator;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class SketchWebSocket implements WebSocketMessageBrokerConfigurer {
    
    /**
     * Configuracion de los endpoints de websocket
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry endpoint) {
        endpoint.addEndpoint("/stompEndpoint").withSockJS();
    }

    /**
     * Configuracion de los canales de mensajes
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
    }
    
}
