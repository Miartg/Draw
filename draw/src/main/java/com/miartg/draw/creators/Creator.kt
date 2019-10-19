package com.miartg.draw.creators

import com.miartg.draw.Touch
import com.miartg.draw.drawables.Drawable
import com.miartg.draw.drawables.DrawablesFactory
import com.miartg.draw.editors.Editor
import com.miartg.draw.geometry.Point

class Creator(private val editor: Editor) : Touch {

    private var drawable: Drawable? = null

    private val start = Point()
    private val end = Point()

    override fun onDown(point: Point) {
        start.set(point)
    }

    override fun onMove(point: Point) {
        end.set(point)
        if (drawable == null && !start.isNear(end, DrawablesFactory.getTolerance(editor.mode))) {
            drawable = DrawablesFactory.createDrawable(editor.mode, editor.style)
                .apply {
                    start(start)
                    stop(end)
                    editor.drawables.add(this)
                }
        } else {
            drawable?.stop(end)
        }

    }

    override fun onUp(point: Point) {
        if (drawable == null && DrawablesFactory.getTolerance(editor.mode) <= 0f) {
            drawable = DrawablesFactory.createDrawable(editor.mode, editor.style).apply {
                editor.drawables.add(this)
            }
        }
        drawable?.complete(point)
        drawable = null
    }

}