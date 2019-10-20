package com.miartg.draw.geometry

data class Oval(val bounds: Rect) : Shape {

    constructor(
        left: Float = 0f,
        top: Float = 0f,
        right: Float = 0f,
        bottom: Float = 0f
    ) : this(Rect(left, top, right, bottom))

    fun set(oval: Oval): Oval {
        bounds.set(oval.bounds)
        return this
    }

    override fun strokeContains(point: Point, precision: Float): Boolean {
        var w = bounds.width
        var h = bounds.height
        //vector center -> point
        val v = tmp1.set(point.x - bounds.centerX, point.y - bounds.centerY)
        //смотрим на элипс большего на precision размера
        w += 2f * precision
        h += 2f * precision
        return if (contains(w, h, v) <= 1) {
            //точка внутри
            w -= 4f * precision
            h -= 4f * precision
            contains(w, h, v) >= 1 // если больше 1, то рядом с грвницей
        } else {
            //точка за элипсом
            false
        }
    }

    companion object {
        private var tmp1 = Vector(0f, 0f)

        /**
         * @return when {
         *      value < 1 -> внутри
         *      value == 1 -> на границе
         *      value > 1 -> снаружи
         * }
         *
         */
        fun contains(width: Float, height: Float, v: Vector): Float {
            return (v.x * v.x) / (width * width * 0.25f) + (v.y * v.y) / (height * height * 0.25f)
        }
    }
}
