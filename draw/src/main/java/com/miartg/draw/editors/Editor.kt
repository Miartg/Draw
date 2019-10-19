package com.miartg.draw.editors

import android.graphics.Color
import com.miartg.draw.Mode
import com.miartg.draw.Touch
import com.miartg.draw.creators.Creator
import com.miartg.draw.drawables.Drawable
import com.miartg.draw.ext.dp
import com.miartg.draw.geometry.Point
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
    private val precision: Float = 24f.dp

    override fun onDown(point: Point) {
        //ищем фигуру
        selectedDrawable = drawables.findLast { it.strokeContains(point, precision) }
        //если не нашли, передаем управление создателю
        if (selectedDrawable == null) {
            creator.onDown(point)
        } else {
            //todo edit
        }
    }

    override fun onMove(point: Point) {
        if (selectedDrawable == null) {
            creator.onMove(point)
        } else {
            //todo edit
        }
    }

    override fun onUp(point: Point) {
        if (selectedDrawable == null) {
            creator.onUp(point)
        } else {
            //todo edit
        }
    }
}
