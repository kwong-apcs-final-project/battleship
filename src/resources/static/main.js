
//TODO: Boat Postion Call back on pointerBoard.js
//TODO: Attack Postion find on boatBaord.js
// TODO: AI attack postino callback on pointer


// Create WebSocket connection.
const socket = new WebSocket('ws://localhost:8080/startGame');

// Connection opened
socket.addEventListener('open', function (event) {
    socket.send('[[{"xPos":6,"yPos":3},{"xPos":1,"yPos":6}],[{"xPos":2,"yPos":5},{"xPos":0,"yPos":5}],[{"xPos":5,"yPos":7},{"xPos":8,"yPos":5}],[{"xPos":7,"yPos":3},{"xPos":4,"yPos":3}],[{"xPos":1,"yPos":6},{"xPos":4,"yPos":3}]]');
});

// Listen for messages
socket.addEventListener('message', function (event) {
    console.log('Message from server ', event.data);
    test2ndWebScoket(event.data);
});

function test2ndWebScoket (uuid) {
    // Create WebSocket connection.
    var socket = new WebSocket('ws://localhost:8080/endTurn');

    // Connection opened
    socket.addEventListener('open', function (event) {
        socket.send('['+uuid+',{"xPos":6,"yPos":3}]');
    });

    // Listen for messages
    socket.addEventListener('message', function (event) {
        console.log('Message from server ', event.data);
    });
}

export function boatPositionCallback(position) {
    console.log(position);

}