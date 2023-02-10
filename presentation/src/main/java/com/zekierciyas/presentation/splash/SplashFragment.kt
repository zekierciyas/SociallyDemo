package com.zekierciyas.presentation.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.zekierciyas.base.setBackground
import com.zekierciyas.base.setDrawable
import com.zekierciyas.base.viewBinding
import com.zekierciyas.presentation.R
import com.zekierciyas.presentation.databinding.SplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.splash_screen) {

    private val binding by viewBinding(SplashScreenBinding::bind)
    private val viewModel: SplashScreenViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeState()

        handleClicks()
    }

    private fun handleClicks() {
        binding.buttonNextV1.setOnClickListener {
            viewModel.updateSplashState()
        }
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.splashState.collect {
                    when (it) {
                        is SplashState.SplashV1 -> {
                            binding.imageViewHero.setDrawable(R.drawable.ic_hero_img_v2)
                            binding.buttonNextV1.setBackground(R.drawable.ic_button_next_v2)
                            binding.progressBar.setDrawable(R.drawable.ic_progress_bar_second)
                        }

                        is SplashState.SplashV2 -> {
                            binding.buttonNextV1.setBackground(R.drawable.ic_button_next_v1)
                            binding.progressBar.setDrawable(R.drawable.ic_progress_bar_third)
                        }

                        is SplashState.SplashV3 -> {
                            Timber.d("Navigating to next screen executed 3")
                            findNavController().navigate(com.zekierciyas.base.R.id.action_splashFragment_to_profileScreenFragment2)
                        }
                    }
                }
            }
        }
    }
}