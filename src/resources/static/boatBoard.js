var width = 1200;
var height = 600;

var stage = new Konva.Stage({
  container: 'boatBoard',
  width: width,
  height: height,
});
var backgroundLayer = new Konva.Layer();
var background = new Konva.Rect( {
  width: width,
  height: height,
  fill: '#000000',
  stroke: 'black',
});
backgroundLayer.add(background);

var pointerRBox = new Konva.Rect({
    x: 900,
    y: 0,
    width: 300,
    height: 300,
    fill: '#00D2FF'

});
backgroundLayer.add(pointerRBox)

var pointerBBox = new Konva.Rect({
    x: 900,
    y: 300,
    width: 300,
    height: 300,
    fill: '#8E1600'

});
backgroundLayer.add(pointerBBox)

var boatBox = new Konva.Rect({
    x:0,
    y:0,
    width:300,
    height: 600,
    fill: '#7E7E7E'
})
backgroundLayer.add(boatBox)

stage.add(backgroundLayer);
var layer = new Konva.Layer();
var rectX = stage.width() / 2 - 50;
var rectY = stage.height() / 2 - 25;

var box = new Konva.Rect({
  x: rectX,
  y: rectY,
  width: 100,
  height: 50,
  fill: '#00D2FF',
  stroke: 'black',
  strokeWidth: 4,
  draggable: true,
});

// add cursor styling
box.on('mouseover', function () {
  document.body.style.cursor = 'pointer';
});
box.on('mouseout', function () {
  document.body.style.cursor = 'default';
});

layer.add(box);
stage.add(layer);