import {newShip, newPointer,} from  './util.js'


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
backgroundLayer.add(grid);

var foreGround = new Konva.Layer();

var toolBoxes = new Konva.Layer();
var pointerRBox = new Konva.Rect({
    x: 900,
    y: 0,
    width: 300,
    height: 300,
    fill: '#8E1600'

});
toolBoxes.add(pointerRBox)
pointerRBox.on('click', ()=> {
  var pos = stage.getRelativePointerPosition();
  newPointer(pos.x, pos.y, foreGround, stage, false, shadowRectangle);
});

var pointerBBox = new Konva.Rect({
    x: 900,
    y: 300,
    width: 300,
    height: 300,
    fill: '#00D2FF'

});
toolBoxes.add(pointerBBox)

pointerBBox.on('click', ()=> {
  var pos = stage.getRelativePointerPosition();
  newPointer(pos.x, pos.y, foreGround, stage, true, shadowRectangle);
});

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