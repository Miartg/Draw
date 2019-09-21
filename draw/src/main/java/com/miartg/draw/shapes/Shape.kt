package com.miartg.draw.shapes

import com.miartg.draw.creators.Creatable

interface Shape: Creatable {

    fun contains(point: Point, precision: Float): Boolean
}
