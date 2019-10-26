package com.miartg.draw.editors

import android.graphics.Color
import com.miartg.draw.Mode
import com.miartg.draw.Touch
import com.miartg.draw.creators.Creator
import com.miartg.draw.drawables.Drawable
import com.miartg.draw.ext.dp
import com.miartg.draw.geometry.Point
import com.miartg.draw.geometry.Vector
import com.miartg.draw.styles.Cap
import com.miartg.draw.styles.DrawStyles
import com.miartg.draw.styles.Stroke

/**
 * Creates and modifies Drawables
 */
class Editor : Touch {

    var mode: Mode = Mode.PENCIL
    var style = DrawStyles(Stroke(5f.dp, Color.parseColor("#979797"), Cap.ROUND))

    val drawables: MutableList<Drawable> = mutableListOf()
    var selectedDrawable: Drawable? = null

    private val creator = Creator(this)
    private val precision: Float = 5f.dp

    private val downPoint = Point()
    private val deltaVector = Vector()

    fun removeSelected() {
        selectedDrawable?.let(drawables::remove)
        selectedDrawable = null
    }

    override fun onDown(point: Point) {
        selectedDrawable = drawables.findLast { it.strokeContains(point, precision) }
        selectedDrawable?.onEditBegin(downPoint.set(point)) ?: creator.onDown(point)
    }

    override fun onMove(point: Point) {
        selectedDrawable?.onEdit(deltaVector.set(downPoint, point)) ?: creator.onMove(point)
    }

    override fun onUp(point: Point) {
        selectedDrawable?.onEditEnd(point) ?: creator.onUp(point)
    }
}
