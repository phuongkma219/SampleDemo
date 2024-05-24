package com.dev.sample.demo.fragment

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResult
import com.dev.sample.demo.R
import com.dev.sample.demo.databinding.FragmentFirstBinding
import com.dev.sample.demo.fragment.dialog.CustomDialog
import com.dev.sample.demo.fragment.viewpager.CollectionDemoFragment

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        binding.tvContent.text = ""
        val text = "First Fragment"
        val spannable = SpannableString(text)
        val onClick = object : ClickableSpan(){
            override fun onClick(widget: View) {
                Log.e(TAG, "onClick: 123123", )
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
                ds.color = ContextCompat.getColor(requireContext(),R.color.red)
            }

        }
        spannable.setSpan(onClick, 0, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)

        binding.tvContent.setText(spannable, TextView.BufferType.SPANNABLE)
        binding.tvContent.movementMethod = LinkMovementMethod.getInstance()

        binding.btnNext.setOnClickListener {
            binding.tvContent.text = "Test Fragment"
            parentFragmentManager.commit {
                setCustomAnimations(
                    R.anim.slide_in, // enter
                    R.anim.fade_out, // exit
                    R.anim.fade_in, // popEnter
                    R.anim.slide_out // popExit
                )
                replace(R.id.fmContainter,SecondFragment())
                val result = "Result"
                setFragmentResult("requestKey", bundleOf("bundleKey" to result))
                addToBackStack(null)
            }
        }

        binding.btnDialog.setOnClickListener {
            val dialog = CustomDialog()
            dialog.show(parentFragmentManager,"TAG")
        }

        binding.btnPager.setOnClickListener {
            parentFragmentManager.commit {
                setCustomAnimations(
                    R.anim.slide_in, // enter
                    R.anim.fade_out, // exit
                    R.anim.fade_in, // popEnter
                    R.anim.slide_out // popExit
                )
                replace(R.id.fmContainter, CollectionDemoFragment())
                addToBackStack(null)
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

    fun TextView.append(string: String?, @ColorRes color: Int){
        string?.let {
            val spannable = SpannableString(string)
            spannable.setSpan(ForegroundColorSpan(ContextCompat.getColor(context,color))
            ,0, spannable.length,Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
            append(spannable)
        }
    }
}