package com.miartg.draw.drawables

import android.graphics.Canvas
import android.graphics.Paint
import com.miartg.draw.creators.Creatable
import com.miartg.draw.editors.Editable
import com.miartg.draw.geometry.Point
import com.miartg.draw.styles.Style

abstract class Drawable(vararg style: Style?) : Creatable, Editable {

    private val styles: List<Style> = style.filterNotNull()

    fun draw(canvas: Canvas, paint: Paint) {
        styles.forEach { style ->
            style.apply(paint)
            onDraw(canvas, paint)
        }
    }

    fun drawSelection(canvas: Canvas, paint: Paint, selectionStyle: Style) {
        selectionStyle.apply(paint)
        onDraw(canvas, paint)
    }

    protected open fun onDraw(canvas: Canvas, paint: Paint) {
        //by default draw nothing
    }

    abstract fun strokeContains(point: Point, precision: Float): Boolean
}