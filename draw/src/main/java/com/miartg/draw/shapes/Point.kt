package com.miartg.draw.shapes

import kotlin.math.abs

data class Point(var x: Float = 0f, var y: Float = 0f) {

    fun set(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

    fun set(point: Point) {
        this.x = point.x
        this.y = point.y
    }

    fun isNear(point: Point, tolerance: Float) =
        abs(point.x - x) <= tolerance && abs(point.y - y) <= tolerance
}
