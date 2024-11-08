package com.example.noteapp.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw3_m4_geeks.R
import com.example.hw3_m4_geeks.databinding.FragmentOnBoardPagingBinding

class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0 -> {
                binding.lottieAnimationView.setAnimation(R.raw.lotti4)
                txtTitle.text = "Удобство"
                btnStart.visibility = View.INVISIBLE
                txtDescription.text = "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно"
            }
            1 -> {
                binding.lottieAnimationView.setAnimation(R.raw.lotti2)
                txtTitle.text = "Организация"
                btnStart.visibility = View.INVISIBLE
                txtDescription.text = "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время."
                circle1.setImageResource(R.drawable.circle_gray)
                circle2.setImageResource(R.drawable.circle)
            }
            2 -> {
                binding.lottieAnimationView.setAnimation(R.raw.lotti3)
                txtTitle.text = "Синхронизация"
                circle3.setImageResource(R.drawable.circle)
                circle2.setImageResource(R.drawable.circle_gray)
                circle1.setImageResource(R.drawable.circle_gray)
                btnStart.visibility = View.VISIBLE
                txtDescription.text = "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте"
            }
        }
    }

    companion object {
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}