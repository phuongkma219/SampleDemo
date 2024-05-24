package com.dev.sample.demo.fragment.viewpager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dev.sample.demo.R

private const val ARG_PARAM = "param1"
class DemoFragment : Fragment() {
    private var param: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param = it.getInt(ARG_PARAM,0)
            Log.e("kkk", "onCreate: $param", )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.tvContent)
        text.text = param.toString()
    }

    companion object {
        fun newInstance(param : Int) =
            DemoFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM, param)
                }
            }
    }
}