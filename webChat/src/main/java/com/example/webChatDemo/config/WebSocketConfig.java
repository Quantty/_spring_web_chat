package com.example.webChatDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    //Simple Text Oriented Messaging Protocol
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
        //withSockJS for browsers that dont support websocket
    }

    //route the messages from one client to another
    // messages with /app will be routed to a defined method
    //messages with /channel will be handled by the broker
    // broker broadcasts the message to al subscribed clients.
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/channel");
    }
}