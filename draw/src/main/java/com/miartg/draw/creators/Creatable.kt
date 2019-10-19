package com.miartg.draw.creators

import com.miartg.draw.geometry.Point

interface Creatable {

    fun start(point: Point)
    fun stop(point: Point)
    fun complete(point: Point)
}