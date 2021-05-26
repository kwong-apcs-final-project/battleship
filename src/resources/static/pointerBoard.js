import {newShip, newPointer,} from  './util.js'
import {pointerPositionCallback} from './main.js'
//TODO: Attack Postion find on boatBaord.js


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
  container: 'pointerBoard',
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
var mainPointer;
export function playerTurn () {
  mainPointer = newPointer(50, 50, foreGround, stage);
  mainPointer.on('dblclick', ()=> {
    if (mainPointer.checkPositions()){
        mainPointer.hide();
        pointerPositionCallback(mainPointer.findAbstractCord()[0])
    }
  });
}

export function aiHit (hasHit) {
  let color;
  if (hasHit) {
    color = "#8E1600";
  } else {
    color = "white";
  }
  var newPointer = mainPointer.clone({
    draggable: false,
    fill: color,
  })
  foreGround.add(newPointer);
  newPointer.show();
}
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
toolBoxes.add(pointerRBox)


var boatBox = new Konva.Rect({
    x:0,
    y:0,
    width:300,
    height: 600,
    fill: '#7E7E7E'
})
toolBoxes.add(boatBox)
stage.add(toolBoxes);


var layer = new Konva.Layer();
shadowRectangle.hide();
layer.add(shadowRectangle);
stage.add(foreGround);
stage.add(layer);