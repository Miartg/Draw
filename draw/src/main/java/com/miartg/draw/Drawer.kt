package com.miartg.draw

import android.graphics.Canvas
import android.graphics.Paint
import com.miartg.draw.drawables.Drawable

class Drawer {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    fun draw(canvas: Canvas, drawables: List<Drawable>) {
        drawables.forEach { drawable-> drawable.draw(canvas, paint) }
    }

}
