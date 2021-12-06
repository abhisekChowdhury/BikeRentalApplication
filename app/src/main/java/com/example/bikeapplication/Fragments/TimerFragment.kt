package com.example.bikeapplication.Fragments

import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bikeapplication.R
import com.example.bikeapplication.ViewModel.MainViewModel
import com.example.bikeapplication.databinding.FragmentTimerBinding

class TimerFragment : Fragment() {
    private lateinit var binding: FragmentTimerBinding
    private lateinit var viewModel: MainViewModel

    var pauseAt: Long = 0
    var count: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = FragmentTimerBinding.inflate(inflater,container,false)

        val transition:TransitionDrawable = binding.constraintContainer.background as TransitionDrawable


        binding.btnStart.setOnClickListener {
            transition.startTransition(500)
            binding.stopWatch.base = SystemClock.elapsedRealtime() - pauseAt
            binding.stopWatch.start()
            binding.btnPause.visibility = View.VISIBLE
            binding.btnPause.isEnabled = true
            binding.btnReset.visibility = View.VISIBLE
            binding.btnReset.isEnabled = true
            binding.btnStart.visibility = View.INVISIBLE
            binding.btnStart.isEnabled = false

        }

        binding.btnReset.setOnClickListener {
            transition.resetTransition()
            binding.stopWatch.base = SystemClock.elapsedRealtime()
            binding.btnPause.visibility = View.INVISIBLE
            binding.btnPause.isEnabled = false
            binding.btnReset.visibility = View.INVISIBLE
            binding.btnReset.isEnabled = false
            binding.btnStart.visibility = View.VISIBLE
            binding.btnStart.isEnabled = true
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnPause.setOnClickListener {
            if(count == 0) {
                pauseAt = SystemClock.elapsedRealtime() - binding.stopWatch.base
                binding.stopWatch.stop()
                binding.btnPause.text = "Resume"
                count = 1
            }
            else if (count == 1){
                binding.stopWatch.base = SystemClock.elapsedRealtime() - pauseAt
                binding.stopWatch.start()
                binding.btnPause.text = "Pause"
                count = 0
            }

        }

        return binding.root

    }
}

