package com.dev.sample.demo.fragment.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dev.sample.demo.databinding.CollectionDemoBinding
import com.google.android.material.tabs.TabLayoutMediator

class CollectionDemoFragment : Fragment() {
    private lateinit var binding :CollectionDemoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = CollectionDemoBinding.inflate(inflater,container,false)
        binding.pager.adapter = DemoCollectionAdapter(this)
        binding.pager.offscreenPageLimit = 2
        TabLayoutMediator(binding.tabLayout,binding.pager){ tab , position ->
            tab.text = "Tab $position"
        }.attach()
        return binding.root
    }
}