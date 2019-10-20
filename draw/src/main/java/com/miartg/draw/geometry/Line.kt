package com.miartg.draw.geometry

data class Line(
    var start: Point,
    var stop: Point
) : Shape {

    constructor(startX: Float = 0f, startY: Float = 0f, stopX: Float = 0f, stopY: Float = 0f) :
            this(Point(startX, startY), Point(stopX, stopY))

    fun set(line: Line): Line {
        start.set(line.start)
        stop.set(line.stop)
        return this
    }

    fun set(startX: Float, startY: Float, stopX: Float, stopY: Float): Line {
        start.set(startX, startY)
        stop.set(stopX, stopY)
        return this
    }

    fun distToPoint(point: Point) = distToPoint(this, point)

    override fun strokeContains(point: Point, precision: Float): Boolean =
        distToPoint(point) <= precision

    companion object {
        private var tmp1 = Vector(0f, 0f)
        private var tmp2 = Vector(0f, 0f)

        fun distToPoint(s: Line, p: Point): Float {
            //v - вектор start -> stop
            val v = tmp1.set(s.start, s.stop)
            //w - вектор start -> p
            val w = tmp2.set(s.start, p)
            val dotWV = w.dot(v)
            //угол туопй -> точка ближе к началу
            if (dotWV <= 0) {
                return s.start.dist(p)
            }
            //скалярное произведение vv
            val dotVV = v.dot(v)
            if (dotVV <= dotWV) {
                return s.stop.dist(p)
            }
            val b = dotWV / dotVV
            //p to Pb
            return p.dist(s.start.x + b * v.x, s.start.y + b * v.y)
        }

        fun verticalStrokeContains(
            x: Float,
            top: Float,
            bottom: Float,
            p: Point,
            precision: Float
        ) =
            x - precision <= p.x && p.x <= x + precision &&
                    top - precision <= p.y && p.y <= bottom + precision

        fun horizontalStrokeContains(
            y: Float,
            left: Float,
            right: Float,
            p: Point,
            precision: Float
        ) =
            y - precision <= p.y && p.y <= y + precision &&
                    left - precision <= p.x && p.x <= right + precision
    }
}
