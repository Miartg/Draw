package com.miartg.draw.geometry

class Rect(
    var left: Float = 0f,
    var top: Float = 0f,
    var right: Float = 0f,
    var bottom: Float = 0f
) : Shape {

    val centerX
        get() = (right + left) * 0.5f

    val centerY
        get() = (bottom + top) * 0.5f

    val width
        get() = right - left

    val height
        get() = bottom - top

    override fun strokeContains(point: Point, precision: Float): Boolean =
        Line.horizontalStrokeContains(top, left, right, point, precision)
                || Line.horizontalStrokeContains(bottom, left, right, point, precision)
                || Line.verticalStrokeContains(left, top, bottom, point, precision)
                || Line.verticalStrokeContains(right, top, bottom, point, precision)


    fun sort() {
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
