package com.miartg.draw

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.container_layout) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.run {
            if(findFragmentById(R.id.container) == null){
                beginTransaction()
                    .add(R.id.container,DrawFragment.newInstance(),  null)
                    .commit()
            }
        }
    }
}
