import {newShip, newPointer} from  './util.js'
import {boatPositionCallback} from './main.js'

//TODO: Spawn Pointer Callback

var width = 1200;
var height = 600;
var blockSnapSize = 60;
var shadowRectangle = new Konva.Rect({
  x: 0,
  y: 0,
  width: blockSnapSize * 1,
  height: blockSnapSize * 1,
  fill: '#FF7B17',
  opacity: 0.6,
  stroke: '#CF6412',
  strokeWidth: 3,
  dash: [20, 2]
});

var stage = new Konva.Stage({
  container: 'boatBoard',
  width: width,
  height: height,
});
var backgroundLayer = new Konva.Layer();
stage.add(backgroundLayer);

var background = new Konva.Rect( {
  width: width,
  height: height,
  fill: '#000000',
  stroke: 'black',
});
backgroundLayer.add(background);

var gridLayer = new Konva.Layer();
var padding = blockSnapSize;
console.log(width, padding, width / padding);
for (var i = 0; i < width / padding; i++) {
  gridLayer.add(new Konva.Line({
    points: [Math.round(i * padding) + 0.5, 0, Math.round(i * padding) + 0.5, height],
    stroke: '#ddd',
    strokeWidth: 1,
  }));
}

//gridLayer.add(new Konva.Line({points: [0,0,10,10]}));
for (var j = 0; j < height / padding; j++) {
  gridLayer.add(new Konva.Line({
    points: [0, Math.round(j * padding), width, Math.round(j * padding)],
    stroke: '#ddd',
    strokeWidth: 0.5,
  }));
}
stage.add(gridLayer)
var grid = new Konva.Rect({
  width: 600,
  height: 600,
  x: 300,
  fill: '#222222'
});
backgroundLayer.add(grid);

var foreGround = new Konva.Layer();

var toolBoxes = new Konva.Layer();
var pointerRBox = new Konva.Rect({
    x: 900,
    y: 0,
    width: 300,
    height: 600,
    fill: '#7E7E7E'

});

var readyMessage  = new Konva.Group();
var readyBox = new Konva.Rect({
    x: 900,
    y: 150,
    width: 300,
    height: 300,
    fill: '#8E1600'

});
var simpleText = new Konva.Text({
  x: 910,
  y: 110 + readyBox.height() / 2,
  text: 'Ready?',
  fontSize: 80,
  fontFamily: 'Calibri',
  fill: 'white',
});
readyMessage.hide();
readyMessage.add(readyBox);
readyMessage.add(simpleText);
toolBoxes.add(pointerRBox);
toolBoxes.add(readyMessage);



var boatBox = new Konva.Rect({
    x:0,
    y:0,
    width:300,
    height: 600,
    fill: '#7E7E7E'
})
toolBoxes.add(boatBox);
////TODO: Boat Postion Call back on pointerBoard.js
var carrier = newShip(0,0,foreGround,stage,5);
var battleship = newShip(0,0,foreGround,stage,4);
var cruiser = newShip(0,0,foreGround,stage,3);
var submerine = newShip(0,0,foreGround,stage,3);
var destroyer = newShip(0,0,foreGround,stage,2);
var listOfAllShips = [carrier,battleship,cruiser, submerine, destroyer];
function checkAllShip () {
  return carrier.checkPositions() && battleship.checkPositions() &&
         cruiser.checkPositions() && submerine.checkPositions() &&
         destroyer.checkPositions();
}

listOfAllShips.forEach(ship => {
  ship.on('dragend', (e) => {
    if ( checkAllShip()) {
      readyMessage.show()
    } else {
      readyMessage.hide()
    }
  });
  ship.on('dblclick', ()=> {
    if ( checkAllShip()) {
      readyMessage.show()
    } else{ 
      readyMessage.hide()
    }
  });
});
readyMessage.on('click', (e) => {
  readyMessage.hide();
  var boatArrays = [];
  listOfAllShips.forEach(ship => {
    ship.dragStop();
    boatArrays.push(ship.findAbstractCord());
  });
  boatPositionCallback(boatArrays);
  //TODO: Can still drag
});

var layer = new Konva.Layer();
shadowRectangle.hide();
layer.add(shadowRectangle);
stage.add(toolBoxes);
stage.add(foreGround);
stage.add(layer);