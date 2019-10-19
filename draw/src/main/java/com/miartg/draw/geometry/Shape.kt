package com.miartg.draw.geometry

interface Shape {

    fun strokeContains(point: Point, precision: Float): Boolean
}
