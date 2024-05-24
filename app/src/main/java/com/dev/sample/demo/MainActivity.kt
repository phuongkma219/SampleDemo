package com.dev.sample.demo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.dev.sample.demo.fragment.FirstFragment

class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
                val firstFragment = FirstFragment()
                replace(R.id.fmContainter, firstFragment)
                addToBackStack("FirstFragment")
        }
    }
}