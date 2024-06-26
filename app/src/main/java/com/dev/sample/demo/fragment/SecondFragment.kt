package com.dev.sample.demo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResult
import com.dev.sample.demo.R
import com.dev.sample.demo.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding : FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        binding.btnNext.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fmContainter,ThirdFragment())
                addToBackStack(null)
            }
        }
        binding.tvBack.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

        parentFragmentManager.setFragmentResultListener("requestKey", this){ _, bundle ->
            val result = bundle.getString("bundleKey")
            result?.let {
                binding.tvContent.text = result
            }
        }
        return binding.root
    }
}