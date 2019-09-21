package com.miartg.draw

import com.miartg.draw.shapes.Point

interface Touch {
    fun onDown(point: Point)
    fun onMove(point: Point)
    fun onUp()
}