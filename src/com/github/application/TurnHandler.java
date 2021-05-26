package com.github.application;

import com.github.battleship.Game;
import com.github.battleship.Location;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;


public class TurnHandler extends TextWebSocketHandler {
    HashMap<String, Game> gameList;
    Game game;

    /**
     * Collects needed fields to do handling
     * @param gameList list O Games
     */
    public TurnHandler (HashMap<String, Game> gameList) {
        this.gameList = gameList;
    }
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        //TODO main.js needs to control game
        JsonArray gameInfo = JsonParser.parseString(message.getPayload()).getAsJsonArray();
        String uuid = new Gson().fromJson(gameInfo.get(0), String.class);
        Location playerHitLocation = new Gson().fromJson(gameInfo.get(1).toString(), Location.class);
        this.game = gameList.get(uuid);
        Location aiHitLocation = game.playRound(playerHitLocation);
        Boolean hasHit = game.playerHit(playerHitLocation);
        Turn turnMessage = new Turn(hasHit, aiHitLocation);
        TextMessage tm = new TextMessage(new Gson().toJson(turnMessage));
        try {
            session.sendMessage(tm); // Let's the Client know what the UUID is
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO Construct Client Turn Changes
        //TODO add AI turn changes into the loop

    }
}
