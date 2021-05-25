package com.github.application;


import com.github.battleship.Game;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.HashMap;
import java.util.UUID;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    HashMap<String, Game> gameSessions = new HashMap<>();

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(startGameHandler(), "/startGame").addInterceptors(new HttpSessionHandshakeInterceptor());
        registry.addHandler(turnHandler(), "/endTurn").addInterceptors(new HttpSessionHandshakeInterceptor());

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
        gameSessions.put(random.toString(), new Game() );
        return new startGameHandler(random.toString(), gameSessions);
    }
}
