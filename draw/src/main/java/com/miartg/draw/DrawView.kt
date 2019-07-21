package com.miartg.draw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

import com.miartg.draw.shapes.Rectangle
import com.miartg.draw.shapes.Shape

class DrawView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private var paint = Paint().apply {
        color = Color.RED
        strokeWidth = 3f
        style = Paint.Style.STROKE
    }

    private var shapes = listOf(
        Rectangle(200f, 100f, 500f, 200f),
        Rectangle(550f, 250f, 700f, 100f),
        Rectangle(100f, 550f, 300f, 800f)
    )

    private var movingShape: Shape? = null

    private var downX = 0f
    private var downY = 0f


    override fun onDraw(canvas: Canvas) {
        for (shape in shapes) {
            shape.draw(canvas, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        val x = event.x
        val y = event.y


        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = x
                downY = y
                onDown(x, y)
            }

            MotionEvent.ACTION_MOVE -> {
                onMove(x, y)
            }


            MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> {
                onUp()
            }
        }


        return true
    }

    private fun onDown(x: Float, y: Float) {
        for (shape in shapes) {
            if (shape.isBelong(x, y)) {
                movingShape = shape
                return
            }
        }
        movingShape = null
    }


    private fun onMove(x: Float, y: Float) {
        movingShape?.onMove(x - downX, y - downY)
        invalidate()
    }


    private fun onUp(){
        movingShape?.onUp()
        invalidate()
    }

}
