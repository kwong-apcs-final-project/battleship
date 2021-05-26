import {newShip, newPointer} from  './util.js'


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
    fill: '#8E1600'

});
toolBoxes.add(pointerRBox)


var boatBox = new Konva.Rect({
    x:0,
    y:0,
    width:300,
    height: 600,
    fill: '#7E7E7E'
})
toolBoxes.add(boatBox);
////TODO: Boat Postion Call back on pointerBoard.js
// TODO: Lock Down Boats, non draggable
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
    
  });
  ship.on('dblclick', ()=> {
    
  });
});


var layer = new Konva.Layer();
shadowRectangle.hide();
layer.add(shadowRectangle);
stage.add(toolBoxes);
stage.add(foreGround);
stage.add(layer);