package com.miartg.draw.ext

import android.content.res.Resources

val Float.dp
    get() = Resources.getSystem().displayMetrics.density * this
