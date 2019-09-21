package com.miartg.draw.editors

import android.graphics.Color
import com.miartg.draw.Mode
import com.miartg.draw.Touch
import com.miartg.draw.creators.Creator
import com.miartg.draw.drawables.Drawable
import com.miartg.draw.shapes.*
import com.miartg.draw.styles.DrawStyles
import com.miartg.draw.styles.Stroke

/**
 * Creates and modifies Drawables
 */
class Editor : Touch {

    var mode: Mode = Mode.LINE
    var style = DrawStyles(Stroke(5f, Color.RED))

    private val creator = Creator(this)
    private var selectedDrawable: Drawable? = null

    private val precision: Float = 20f

    val drawables: MutableList<Drawable> = mutableListOf()


    override fun onDown(point: Point) {

        //ищем фигуру
        val drawable = drawables.find { it.contains(point, precision) }
        //если не нашли, передаем управление создателю
        if (drawable == null) {
            creator.onDown(point)
        } else {
            selectedDrawable = drawable
        }

    }

    override fun onMove(point: Point) {
        creator.onMove(point)
    }

    override fun onUp() {
        creator.onUp()
    }
}
