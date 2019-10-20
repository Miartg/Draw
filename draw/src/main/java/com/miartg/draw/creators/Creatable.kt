package com.miartg.draw.creators

import com.miartg.draw.geometry.Point

interface Creatable {

    fun createBegin(point: Point)
    fun createUpdate(point: Point)
    fun createEnd(point: Point)
}