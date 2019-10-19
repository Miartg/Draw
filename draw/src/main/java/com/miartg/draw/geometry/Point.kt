package com.miartg.draw.geometry

import kotlin.math.abs
import kotlin.math.sqrt

data class Point(var x: Float = 0f, var y: Float = 0f) {

    fun set(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

    fun set(p: Point) {
        this.x = p.x
        this.y = p.y
    }

    fun dist(p: Point) = dist(x, y, p.x, p.y)

    fun dist(x: Float, y: Float) = dist(this.x, this.y, x, y)

    fun isNear(point: Point, tolerance: Float) = isNear(point.x, point.y, tolerance)

    fun isNear(x: Float, y: Float, tolerance: Float) =
        abs(x - this.x) <= tolerance && abs(y - this.y) <= tolerance

    companion object {
        fun dist(x1: Float, y1: Float, x2: Float, y2: Float): Float {
            val x = x2 - x1
            val y = y2 - y1
            return sqrt(x * x + y * y)
        }
    }
}
