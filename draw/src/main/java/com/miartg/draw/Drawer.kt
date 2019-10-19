package com.miartg.draw

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.miartg.draw.drawables.Drawable
import com.miartg.draw.ext.dp
import com.miartg.draw.styles.Cap
import com.miartg.draw.styles.Stroke

class Drawer(
    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG),
    private val selectionStyle: Stroke = Stroke(5f.dp, Color.parseColor("#1477FF"), Cap.ROUND)
) {

    fun draw(canvas: Canvas, drawables: List<Drawable>) {
        drawables.forEach { drawable -> drawable.draw(canvas, paint) }
    }

    fun drawSelection(canvas: Canvas, selectionDrawable: Drawable?) {
        selectionDrawable?.drawSelection(canvas, paint, selectionStyle)
    }
}
