package com.github.application;


import com.github.battleship.Game;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    HashMap<UUID, Game> gameSessions = new HashMap<UUID, Game>();
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(startGameHandler(), "/startGame").setAllowedOrigins("*").withSockJS();
        registry.addHandler(turnHandler(), "/endTurn").setAllowedOrigins("*").withSockJS();

    }

    @Bean
    public WebSocketHandler turnHandler() {
        return new TurnHandler(gameSessions);
    }
    @Bean
    public WebSocketHandler startGameHandler() {
        UUID random = UUID.randomUUID();
        while (gameSessions.containsKey(random)){
            random = UUID.randomUUID();
        }
        gameSessions.put(random, new Game() );
        return new startGameHandler(random, gameSessions);
    }
}
