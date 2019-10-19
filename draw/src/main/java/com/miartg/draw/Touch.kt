package com.miartg.draw

import com.miartg.draw.geometry.Point

interface Touch {
    fun onDown(point: Point)
    fun onMove(point: Point)
    fun onUp(point: Point)
}
