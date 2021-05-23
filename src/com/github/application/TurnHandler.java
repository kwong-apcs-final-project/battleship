package com.github.application;

import com.github.battleship.Game;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.UUID;


public class TurnHandler extends TextWebSocketHandler {
    HashMap<UUID, Game> gameList;
    Game game;
    public TurnHandler (HashMap<UUID, Game> gameList) {
        this.gameList = gameList;
    }
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {

    }
}
