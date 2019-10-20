package com.miartg.draw.drawables

import android.graphics.*
import com.miartg.draw.geometry.Point
import com.miartg.draw.geometry.Vector
import com.miartg.draw.styles.Stroke
import kotlin.math.abs

class PencilDrawable(stroke: Stroke?) : Drawable(stroke) {

    private val path = Path()
    private lateinit var pathMeasure: PathMeasure
    private val matrix = Matrix()
    private val translateVector = Vector()


    //----
    //Draw
    //----

    override fun onDraw(canvas: Canvas, paint: Paint) {
        canvas.drawPath(path, paint)
    }


    //------
    //Create
    //------

    override fun createBegin(point: Point) {
        path.moveTo(point.x, point.y)
        lastPoint.set(point)
    }

    override fun createUpdate(point: Point) {
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

    override fun createEnd(point: Point) {
        if (path.isEmpty) {
            path.addCircle(point.x, point.y, 1f, Path.Direction.CW)
        }
        pathMeasure = PathMeasure(path, false)
    }


    //----
    //Edit
    //----

    override fun editBegin(point: Point) {
        lastDelta.set(0f, 0f)
    }

    override fun editUpdate(delta: Vector) {
        matrix.setTranslate(delta.x - lastDelta.x, delta.y - lastDelta.y)
        path.transform(matrix)
        lastDelta.set(delta)
    }

    override fun editEnd(point: Point) {
        translateVector += lastDelta
    }


    //--------
    //Contains
    //--------

    override fun strokeContains(point: Point, precision: Float): Boolean {
        val len = pathMeasure.length
        var d = 0f
        do {
            pathMeasure.getPosTan(d, pos, tan)
            if (point.isNear(pos[0] + translateVector.x, pos[1] + translateVector.y, precision)) {
                return true
            }
            d += precision
        } while (d <= len)

        return false
    }

    companion object {
        private const val TOUCH_TOLERANCE = 4f
        private val lastPoint = Point()
        private val lastDelta = Vector()
        private val pos = FloatArray(2)
        private val tan = FloatArray(2)
    }
}
