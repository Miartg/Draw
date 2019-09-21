package com.miartg.draw.drawables

import android.graphics.Canvas
import android.graphics.Paint
import com.miartg.draw.creators.Creatable
import com.miartg.draw.shapes.Point
import com.miartg.draw.shapes.Shape
import com.miartg.draw.styles.Style

abstract class Drawable(open val shape: Shape, vararg style: Style?): Shape by shape {

    private val styles: List<Style> = style.filterNotNull()

    fun draw(canvas: Canvas, paint: Paint) {
        styles.forEach { style ->
            style.apply(paint)
            onDraw(canvas, paint)
        }
    }

    protected open fun onDraw(canvas: Canvas, paint: Paint) {
        //by default draw nothing
    }

}