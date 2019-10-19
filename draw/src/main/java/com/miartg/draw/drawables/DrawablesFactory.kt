package com.miartg.draw.drawables

import com.miartg.draw.Mode
import com.miartg.draw.geometry.Line
import com.miartg.draw.geometry.Oval
import com.miartg.draw.geometry.Rect
import com.miartg.draw.styles.DrawStyles

object DrawablesFactory {

    fun createDrawable(mode: Mode, drawStyles: DrawStyles) = when(mode) {
        Mode.LINE -> LineDrawable(Line(), drawStyles.stroke?.copy())
        Mode.OVAL -> OvalDrawable(Oval(), drawStyles.stroke?.copy(), drawStyles.solid?.copy())
        Mode.RECT -> RectDrawable(Rect(), drawStyles.stroke?.copy(), drawStyles.solid?.copy())
        Mode.PENCIL -> PencilDrawable(drawStyles.stroke?.copy())
    }

    fun getTolerance(mode: Mode) = when (mode) {
        Mode.PENCIL -> -1f
        else -> 4f
    }

}