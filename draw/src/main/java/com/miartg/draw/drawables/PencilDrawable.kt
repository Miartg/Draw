package com.miartg.draw.drawables

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathMeasure
import com.miartg.draw.geometry.Point
import com.miartg.draw.styles.Stroke
import kotlin.math.abs

class PencilDrawable(stroke: Stroke?) : Drawable(stroke) {

    private val path = Path()
    private lateinit var pathMeasure: PathMeasure

    override fun onDraw(canvas: Canvas, paint: Paint) {
        canvas.drawPath(path, paint)
    }

    override fun strokeContains(point: Point, precision: Float): Boolean {
        val len = pathMeasure.length
        var d = 0f

        do {
            pathMeasure.getPosTan(d, pos, tan)
            if (point.isNear(pos[0], pos[1], precision)) {
                return true
            }
            d += precision
        } while (d <= len)

        return false
    }

    override fun start(point: Point) {
        path.moveTo(point.x, point.y)
        lastPoint.set(point)
    }

    override fun stop(point: Point) {
        if (abs(point.x - lastPoint.x) >= TOUCH_TOLERANCE || abs(point.y - lastPoint.y) >= TOUCH_TOLERANCE) {
            path.quadTo(
                lastPoint.x,
                lastPoint.y,
                (point.x + lastPoint.x) * 0.5f,
                (point.y + lastPoint.y) * 0.5f
            )
            lastPoint.set(point)
        }
    }

    override fun complete(point: Point) {
        if (path.isEmpty) {
            path.addCircle(point.x, point.y, 1f, Path.Direction.CW)
        }
        pathMeasure = PathMeasure(path, false)
    }

    companion object {
        private const val TOUCH_TOLERANCE = 4f
        private val lastPoint = Point()
        private val pos = FloatArray(2)
        private val tan = FloatArray(2)
    }
}
