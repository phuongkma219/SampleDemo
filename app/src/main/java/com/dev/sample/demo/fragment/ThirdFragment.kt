package com.dev.sample.demo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.dev.sample.demo.R
import com.dev.sample.demo.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private lateinit var binding : FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(layoutInflater)
        binding.tvBack.setOnClickListener{
            parentFragmentManager.popBackStack()
        }
        binding.btnNext.setOnClickListener{
            parentFragmentManager.popBackStack(FirstFragment.TAG,0)
        }
        return binding.root
    }
}