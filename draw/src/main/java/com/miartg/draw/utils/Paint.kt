package com.miartg.draw.utils

import android.graphics.Paint
import com.miartg.draw.styles.Stroke

private fun Paint.applyStrokeStyle(style: Stroke): Paint {
    this.style = Paint.Style.STROKE
    color = style.color
    strokeWidth = style.width
    return this
}