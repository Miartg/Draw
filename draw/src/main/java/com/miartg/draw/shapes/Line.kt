package com.miartg.draw.shapes

data class Line(
    var start: Point,
    var stop: Point
) : Shape {

    constructor(startX: Float = 0f, startY: Float = 0f, stopX: Float = 0f, stopY: Float = 0f) :
            this(Point(startX, startY), Point(stopX, stopY))

    override fun contains(point: Point, precision: Float): Boolean =
        false

    override fun start(point: Point) {
        start.set(point)
    }

    override fun stop(point: Point) {
        stop.set(point)
    }

    override fun complete() {
        //no need complete
    }
}
