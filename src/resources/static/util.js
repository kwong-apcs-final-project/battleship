
var width = 1200;
var height = 600;
var shadowOffset = 20;
var tween = null;
var blockSnapSize = 60;
/*
*/

export function newShip(x, y, layer, stage, size) {
    
    var shadow = new Konva.Rect({
        x: 0,
        y: 0,
        width: blockSnapSize * 1,
        height: blockSnapSize * size,
        fill: '#FF7B17',
        opacity: 0.6,
        stroke: '#CF6412',
        strokeWidth: 3,
        dash: [20, 2]
      });
    shadow.hide();

    layer.add(shadow)      
    let rectangle = new Konva.Rect({
        x: x,
        y: y,
        width: blockSnapSize * 1,
        height: blockSnapSize * size,
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
    rectangle.on('dblclick', ()=> {
        shadow.rotate(-90);
        rectangle.rotate(-90);
        stage.batchDraw();
    });

    rectangle.checkPositions =  () => {
        var positions = rectangle.findAbstractCord();
        var correct = true;
        positions.forEach(location => {
            if (location.x <= 0 || location.x >= 10 || location.y <= 0 || location.y >= 10 ) {
                correct = false;
            }
        });
        return correct;
    }
    rectangle.findAbstractCord = () => {
        var segmentCord = rectangle.findSegementCord();
        let size = rectangle.findAbstractSize();
        let rotation = rectangle.rotation();
        //find Coterminal 
        
        while (rotation <= 0) {
            rotation+= 360
        } 
        // Only 4 Positions
        // If 0 or 360
        var listOfLocations = [];
        for (let i = 1; i <= size; i++) {
            var loc = {x: 0, y:0};
            if (rotation == 0 || rotation == 360) {
                loc.x = segmentCord.x + 1;
                loc.y = segmentCord.y + i;
            } else
            if (rotation == 90) {
                loc.x = segmentCord.x + 1- i;
                loc.y = segmentCord.y + 1;
            } else
            if (rotation == 180 ) {
                loc.x = segmentCord.x;
                loc.y = segmentCord.y + 1 - i;
            } else
            if (rotation == 270 ) {
                loc.x = segmentCord.x + i;
                loc.y = segmentCord.y;
            }
            listOfLocations.push(loc);
        }
        return listOfLocations;
        
    }

    rectangle.findSegementCord = () => {
        let xMinusOffset  = rectangle.x() - 300;
        let yMinusOffset = rectangle.y();

        let segmentX = xMinusOffset/60
        let segmentY = yMinusOffset/60;
        var segmentCord = { x: segmentX, y: segmentY};
        return segmentCord;
    }

    rectangle.findAbstractSize = () => {
        return (rectangle.height()/rectangle.width());
    }

    rectangle.dragStop = () => {
        rectangle.stopDrag();
    }
    
    layer.add(rectangle);
    return rectangle;
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
