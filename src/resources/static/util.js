var width = 1200;
var height = 600;
var shadowOffset = 20;
var tween = null;
var blockSnapSize = 60;

export function newRectangle(x, y, layer, stage) {
    let rectangle = new Konva.Rect({
        x: x,
        y: y,
        width: blockSnapSize * 1,
        height: blockSnapSize * 1,
        fill: '#fff',
        stroke: '#ddd',
        strokeWidth: 1,
        shadowColor: 'black',
        shadowBlur: 2,
        shadowOffset: {x : 1, y : 1},
        shadowOpacity: 0.4,
        draggable: true
    });
    rectangle.on('dragstart', (e) => {
        shadow.show();
        shadow.moveToTop();
        rectangle.moveToTop();
    });
    rectangle.on('dragend', (e) => {
        rectangle.position({
        x: Math.round(rectangle.x() / blockSnapSize) * blockSnapSize,
        y: Math.round(rectangle.y() / blockSnapSize) * blockSnapSize
        });
        stage.batchDraw();
        shadow.hide();
    });
    rectangle.on('dragmove', (e) => {
        shadow.position({
        x: Math.round(rectangle.x() / blockSnapSize) * blockSnapSize,
        y: Math.round(rectangle.y() / blockSnapSize) * blockSnapSize
        });
        stage.batchDraw();
    });
    layer.add(rectangle);
}

export function newShip(x, y, layer, stage, shadow, size) {
    let rectangle = new Konva.Ellipse({
        x: x,
        y: y,
        width: blockSnapSize * 1,
        height: blockSnapSize * size,
        radiusX: blockSnapSize/2,
        radiusY: blockSnapSize/2,
        fill: '#fff',
        stroke: '#ddd',
        strokeWidth: 1,
        shadowColor: 'black',
        shadowBlur: 2,
        shadowOffset: {x : 1, y : 1},
        shadowOpacity: 0.4,
        draggable: true
    });
    rectangle.on('dragstart', (e) => {
        shadow.show();
        shadow.moveToTop();
        rectangle.moveToTop();
    });
    rectangle.on('dragend', (e) => {
        rectangle.position({
        x: Math.round(rectangle.x() / blockSnapSize) * blockSnapSize,
        y: Math.round(rectangle.y() / blockSnapSize) * blockSnapSize
        });
        stage.batchDraw();
        shadow.hide();
    });
    rectangle.on('dragmove', (e) => {
        shadow.position({
        x: Math.round(rectangle.x() / blockSnapSize) * blockSnapSize,
        y: Math.round(rectangle.y() / blockSnapSize) * blockSnapSize
        });
        stage.batchDraw();
    });
    layer.add(rectangle);
}



/**
 * Adds Pionter to specfied Stage
 * @param {Number} x
 * @param {Number} y 
 * @param {*} layer 
 * @param {*} stage 
 * @param {*} miss
 * @param {*} shadow 
 */
export function newPointer(x, y, layer, stage, miss, shadow) {
    let color = '#8E1600'
    if (miss) {
        color = '#FFFFFF'
    }
    let rectangle = new Konva.Rect({
        x: x,
        y: y,
        width: blockSnapSize * 1/2,
        height: blockSnapSize * 1/2,
        fill: color,
        stroke: '#ddd',
        strokeWidth: 1,
        shadowColor: 'black',
        shadowBlur: 2,
        shadowOffset: {x : 1, y : 1},
        shadowOpacity: 0.4,
        draggable: true
    });
    rectangle.on('dragstart', (e) => {
        shadow.show();
        shadow.moveToTop();
        rectangle.moveToTop();
    });
    rectangle.on('dragend', (e) => {
        let offset = blockSnapSize/4;
        let x = (Math.round(rectangle.x() / blockSnapSize) * blockSnapSize) + offset;
        let y = (Math.round(rectangle.y() / blockSnapSize) * blockSnapSize) + offset;
        rectangle.position({
        x: x,
        y: y
        });
        stage.batchDraw();
        shadow.hide();
    });
    rectangle.on('dragmove', (e) => {
        shadow.position({
        x: Math.round(rectangle.x() / blockSnapSize) * blockSnapSize,
        y: Math.round(rectangle.y() / blockSnapSize) * blockSnapSize
        });
        stage.batchDraw();
    });
    layer.add(rectangle);
}
