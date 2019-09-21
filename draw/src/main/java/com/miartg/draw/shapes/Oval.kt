package com.miartg.draw.shapes

data class Oval(
    val bounds: Rect
) : Shape by bounds {

    constructor(
        left: Float = 0f,
        top: Float = 0f,
        right: Float = 0f,
        bottom: Float = 0f
    ) : this(Rect(left, top, right, bottom))

}
