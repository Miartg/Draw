package com.miartg.draw

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.draw_fragment.*

class DrawFragment : Fragment(R.layout.draw_fragment) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        toolbar.setOnMenuItemClickListener { item ->
            draw_view.mode = when(item.itemId) {
                R.id.line -> Mode.LINE
                R.id.pencil -> Mode.PENCIL
                R.id.oval -> Mode.OVAL
                R.id.rectangle -> Mode.RECT
                else -> throw IllegalStateException("Unsupported Mode")
            }
            toolbar.title = item.title
            true
        }
    }

    companion object{
        fun newInstance() = DrawFragment()
    }

}
