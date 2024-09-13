package com.example.hw3_m4_geeks.ui.fragments.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.hw3_m4_geeks.R
import com.example.hw3_m4_geeks.databinding.FragmentOnBoardBinding
import com.example.hw3_m4_geeks.ui.adapter.OnBoardPagerAdapter
import com.example.noteapp.utils.PreferenceHelper

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpListeners()
    }

    private fun initialize() {
        binding.viewPager2.adapter = OnBoardPagerAdapter(this)
    }

    private fun setUpListeners() = with(binding.viewPager2) {
        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) = with(binding) {
                super.onPageSelected(position)
                if (position == 2) {
                    binding.txtSkip.visibility = View.INVISIBLE
                } else {
                    binding.txtSkip.visibility = View.VISIBLE
                }
            }
        })
        binding.btnStart.setOnClickListener {
            val sharedPreferences = PreferenceHelper()
            sharedPreferences.unit(requireContext())
            sharedPreferences.isOnBoardShown = true
            findNavController().navigate(R.id.action_onBoardFragment_to_noteFragment)
        }
    }
}