package com.miartg.draw.drawables

import com.miartg.draw.Mode
import com.miartg.draw.shapes.Oval
import com.miartg.draw.shapes.Line
import com.miartg.draw.shapes.Rect
import com.miartg.draw.styles.DrawStyles

object DrawablesFactory {

    fun createDrawable(mode: Mode, drawStyles: DrawStyles) = when(mode) {
        Mode.LINE -> LineDrawable(Line(), drawStyles.stroke?.copy())
        Mode.OVAL -> OvalDrawable(Oval(), drawStyles.stroke?.copy(), drawStyles.solid?.copy())
        Mode.RECT -> RectDrawable(Rect(), drawStyles.stroke?.copy(), drawStyles.solid?.copy())
    }
}