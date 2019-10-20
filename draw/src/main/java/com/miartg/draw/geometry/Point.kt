package com.miartg.draw.geometry

import kotlin.math.abs
import kotlin.math.sqrt

data class Point(var x: Float = 0f, var y: Float = 0f) {

    fun set(x: Float, y: Float): Point {
        this.x = x
        this.y = y
        return this
    }

    fun set(p: Point): Point {
        this.x = p.x
        this.y = p.y
        return this
    }

    operator fun plusAssign(point: Point) {
        x += point.x
        y += point.y
    }

    operator fun plusAssign(vector: Vector) {
        x += vector.x
        y += vector.y
    }

    fun dist(p: Point) = dist(x, y, p.x, p.y)

    fun dist(x: Float, y: Float) = dist(this.x, this.y, x, y)

    fun isNear(point: Point, tolerance: Float) = isNear(point.x, point.y, tolerance)

    fun isNear(x: Float, y: Float, tolerance: Float) = isNear(this.x, this.y, x, y, tolerance)

    companion object {
        fun dist(x1: Float, y1: Float, x2: Float, y2: Float): Float {
            val x = x2 - x1
            val y = y2 - y1
            return sqrt(x * x + y * y)
        }

        fun isNear(x1: Float, y1: Float, x2: Float, y2: Float, tolerance: Float) =
            abs(x2 - x1) <= tolerance && abs(y2 - y1) <= tolerance
    }
}
