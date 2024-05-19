package com.dev.sample.demo.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.dev.sample.demo.R
import com.dev.sample.demo.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        binding.btnNext.setOnClickListener {
            binding.tvContent.text = "Test Fragment"
            parentFragmentManager.commit {
                setCustomAnimations(
                    R.anim.slide_in, // enter
                    R.anim.fade_out, // exit
                    R.anim.fade_in, // popEnter
                    R.anim.slide_out // popExit
                )
                add(R.id.fmContainter,SecondFragment())
                addToBackStack(TAG)
            }
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: ", )
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ", )
    }

    companion object{
         const val TAG = "FirstFragment"
    }
}