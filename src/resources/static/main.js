import {playerTurn, aiHit} from './pointerBoard.js';
import {handleHit} from './boatBoard.js';
//TODO: Attack Postion find on boatBaord.js
// TODO: AI attack postino callback on pointer

var uuid = "";
export function boatPositionCallback(position) {
    
    var socket = new WebSocket('ws://localhost:8080/startGame');
    console.log(JSON.stringify(position));
    let string = JSON.stringify(position);
    // Connection opened
    socket.addEventListener('open', function (event) {
        socket.send(string);
    });

    // Listen for messages
    socket.addEventListener('message', function (event) {
        uuid = event.data;
        playerTurn();
    });
}

export function pointerPositionCallback(endTurn) {
    
    var socket2 = new WebSocket('ws://localhost:8080/endTurn');
    console.log(JSON.stringify([uuid, endTurn]));
    let string = JSON.stringify([uuid, endTurn]);
    // Connection opened
    socket2.addEventListener('open', function (event) {
        socket2.send(string);
    });

    // Listen for messages
    socket2.addEventListener('message', function (event) {
        console.log( event.data );
        var aiTurn = JSON.parse(event.data);
        aiHit(aiTurn.hasHit);
        handleHit(aiTurn.aiHit)
    });
}