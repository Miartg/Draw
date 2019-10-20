package com.miartg.draw.editors

import com.miartg.draw.geometry.Point
import com.miartg.draw.geometry.Vector

interface Editable {

    fun editBegin(point: Point)
    fun editUpdate(delta: Vector)
    fun editEnd(point: Point)
}