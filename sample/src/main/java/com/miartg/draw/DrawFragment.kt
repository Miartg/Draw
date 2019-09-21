package com.miartg.draw

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.draw_fragment.*
import java.lang.IllegalStateException

class DrawFragment : Fragment(R.layout.draw_fragment) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        toolbar.setOnMenuItemClickListener {item ->
            draw_view.mode = when(item.itemId) {
                R.id.line -> Mode.LINE
                R.id.oval -> Mode.OVAL
                R.id.rectangle -> Mode.RECT
                else -> throw IllegalStateException("Unsupported Mode")
            }
            true
        }
    }

    companion object{
        fun newInstance() = DrawFragment()
    }

}
