package com.github.application;

import com.github.battleship.Game;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.UUID;

public class startGameHandler extends TextWebSocketHandler {

    UUID uuid;
    HashMap<UUID, Game> listGames;

    /**
     * Gave Needed fields for Handler to handle
     * @param randomUUID
     * @param gameSessions
     */
    public startGameHandler(UUID randomUUID, HashMap<UUID, Game> gameSessions) {
        uuid = randomUUID;
        listGames = gameSessions;
    }
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        //TODO Figure out way to JSON ify game for client
        //TODO Give jsonfied Game for CLient
    }
}
