package com.github.application;

import com.github.battleship.Game;
import com.github.battleship.Location;
import com.google.gson.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.JsonbMessageConverter;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class startGameHandler extends BinaryWebSocketHandler {

    UUID uuid;
    HashMap<UUID, Game> listGames;

    public startGameHandler(UUID randomUUID, HashMap<UUID, Game> gameSessions) {
        uuid = randomUUID;
        listGames = gameSessions;
    }

    /*
        Adds the deserialized Locs using gson
        https://github.com/google/gson/blob/master/extras/src/main/java/com/google/gson/extras/examples/rawcollections/RawCollectionsExample.java
     */
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        JsonArray array = JsonParser.parseString(message.getPayload()).getAsJsonArray();
        ArrayList<ArrayList<Location>> allBoatLocs = new ArrayList<>(); // Creates the mater ArrayList
        for (JsonElement je :
                array) {
            ArrayList<Location> boatLocs = new ArrayList<>();
            JsonArray locArray = JsonParser.parseString(je.toString()).getAsJsonArray();
            for (JsonElement boatLoc :
                    locArray) {
                Location loc = new Gson().fromJson(boatLoc.toString(), Location.class);
                boatLocs.add(loc);
            }
            allBoatLocs.add(boatLocs);
        }
        Game newGame = new Game ();
        newGame.gameBootup(allBoatLocs.get(0), allBoatLocs.get(1), allBoatLocs.get(2),
                allBoatLocs.get(3), allBoatLocs.get(4) ); // Passes on the arraylists
        listGames.put(uuid, newGame);
        TextMessage tm = new TextMessage( uuid.toString());
        try {
            session.sendMessage(tm); // Let's the Client know what the UUID is
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//		ArrayList<ArrayList<Location>> test = new ArrayList<>();
//		for (int i = 0; i < 5; i++) {
//			ArrayList<Location> t1 = new ArrayList<>();
//			for (int j = 0; j < 2; j++) {
//				Location loc = new Location(new Random().nextInt(10), new Random().nextInt(10));
//				t1.add(loc);
//			}
//			test.add(t1);
//		}
//		String json = new Gson().toJson(test);
//		JsonArray array = JsonParser.parseString(json).getAsJsonArray();
//		ArrayList<ArrayList<Location>> allBoatLocs = new ArrayList<>();
//        for (JsonElement je :
//                array) {
//            ArrayList<Location> boatLocs = new ArrayList<>();
//            JsonArray locArray = JsonParser.parseString(je.toString()).getAsJsonArray();
//            for (JsonElement boatLoc :
//                    locArray) {
//                 Location loc = new Gson().fromJson(boatLoc.toString(), Location.class);
//                 boatLocs.add(loc);
//            }
//            allBoatLocs.add(boatLocs);
//        }
////        String JSON ="{\"master\":"+json+"}";
////
////        GameStartMessage gameStartMessage =  new Gson().fromJson( JSON, GameStartMessage.class);
////        System.out.println(gameStartMessage.toString());
//    }
}
