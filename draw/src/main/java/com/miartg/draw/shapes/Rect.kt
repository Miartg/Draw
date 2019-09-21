package com.miartg.draw.shapes

class Rect(
    var left: Float = 0f,
    var top: Float = 0f,
    var right: Float = 0f,
    var bottom: Float = 0f
) : Shape {

    override fun contains(point: Point, precision: Float): Boolean =
        false

    override fun start(point: Point) {
        left = point.x
        top = point.y
    }

    override fun stop(point: Point) {
        right = point.x
        bottom = point.y
    }

    override fun complete(){
        sort()
    }

    private fun sort(){
        if (left > right) {
            val temp = left
            left = right
            right = temp
        }
        if (top > bottom) {
            val temp = top
            top = bottom
            bottom = temp
        }
    }
}
