package com.miartg.draw.geometry

class Vector(
    var x: Float,
    var y: Float
) {

    fun set(x: Float, y: Float): Vector {
        this.x = x
        this.y = y
        return this
    }

    fun set(start: Point, stop: Point): Vector {
        x = stop.x - start.x
        y = stop.y - start.y
        return this
    }

    fun dot(v: Vector) = v.x * x + v.y * y

    companion object {
        var tmp1 = Vector(0f, 0f)
        var tmp2 = Vector(0f, 0f)
        fun dot(x1: Float, y1: Float, x2: Float, y2: Float) = x1 * x2 + y1 * y2
    }
}
