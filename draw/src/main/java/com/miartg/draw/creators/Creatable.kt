package com.miartg.draw.creators

import com.miartg.draw.geometry.Point

interface Creatable {

    fun onCreateBegin(point: Point)
    fun onCreate(point: Point)
    fun onCreateEnd(point: Point)
}