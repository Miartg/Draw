package com.miartg.draw.creators

import com.miartg.draw.Touch
import com.miartg.draw.drawables.Drawable
import com.miartg.draw.drawables.DrawablesFactory
import com.miartg.draw.editors.Editor
import com.miartg.draw.shapes.Point

class Creator(
    private val editor: Editor
) : Touch {

    private var drawable: Drawable? = null

    private val start = Point()
    private val end = Point()

    override fun onDown(point: Point) {
        start.set(point)
    }

    override fun onMove(point: Point) {
        end.set(point)
        if (drawable == null && !start.isNear(end, TOLERANCE)) {
            drawable = DrawablesFactory
                .createDrawable(editor.mode, editor.style).apply {
                    start(start)
                    stop(end)
                    editor.drawables.add(this)
                }
        } else {
            drawable?.stop(end)
        }

    }

    override fun onUp() {
        drawable = null
    }

    companion object {
        const val TOLERANCE = 4f
    }
}