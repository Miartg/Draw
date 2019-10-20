package com.miartg.draw.geometry

data class Vector(
    var x: Float = 0f,
    var y: Float = 0f
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

    fun set(vector: Vector): Vector {
        x = vector.x
        y = vector.y
        return this
    }

    operator fun plusAssign(vector: Vector) {
        x += vector.x
        y += vector.y
    }

    fun dot(v: Vector) = v.x * x + v.y * y

    companion object {
        fun dot(x1: Float, y1: Float, x2: Float, y2: Float) = x1 * x2 + y1 * y2
    }
}
