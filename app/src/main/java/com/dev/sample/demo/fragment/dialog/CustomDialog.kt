package com.dev.sample.demo.fragment.dialog

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.dev.sample.demo.databinding.CustomDialogLayoutBinding

class CustomDialog : DialogFragment() {
    private lateinit var binding : CustomDialogLayoutBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = CustomDialogLayoutBinding.inflate(layoutInflater)

        binding.btnCancel.setOnClickListener {
            dismissAllowingStateLoss()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}