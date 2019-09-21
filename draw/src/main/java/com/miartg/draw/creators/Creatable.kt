package com.miartg.draw.creators

import com.miartg.draw.shapes.Point

interface Creatable {

    fun start(point: Point)
    fun stop(point: Point)
    fun complete()
}