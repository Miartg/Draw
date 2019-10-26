package com.miartg.draw.editors

import com.miartg.draw.geometry.Point
import com.miartg.draw.geometry.Vector

interface Editable {

    fun onEditBegin(point: Point)
    fun onEdit(delta: Vector)
    fun onEditEnd(point: Point)
}