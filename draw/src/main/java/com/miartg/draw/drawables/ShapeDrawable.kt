package com.miartg.draw.drawables

import com.miartg.draw.geometry.Shape
import com.miartg.draw.styles.Style

abstract class ShapeDrawable(
    open val shape: Shape,
    vararg style: Style?
) : Drawable(*style), Shape by shape
