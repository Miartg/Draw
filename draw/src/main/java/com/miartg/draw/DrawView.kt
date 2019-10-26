package com.miartg.draw

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.miartg.draw.editors.Editor
import com.miartg.draw.geometry.Point

class DrawView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    var mode: Mode
        get() = editor.mode
        set(value) {
            editor.mode = value
        }

    private val editor = Editor()
    private val drawer = Drawer()
    private val touchEventPoint = Point()

    override fun onDraw(canvas: Canvas) {
       drawer.draw(canvas, editor.drawables)
        drawer.drawSelection(canvas, editor.selectedDrawable)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        touchEventPoint.set(event.x , event.y)

        when (event.action) {
            MotionEvent.ACTION_DOWN -> editor.onDown(touchEventPoint)
            MotionEvent.ACTION_MOVE -> editor.onMove(touchEventPoint)
            MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> editor.onUp(touchEventPoint)
        }
        invalidate()
        return true
    }

    fun removeSelected() {
        editor.removeSelected()
        invalidate()
    }

}
