package com.zekierciyas.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.zekierciyas.base.viewBinding
import com.zekierciyas.presentation.databinding.SplashScreenBinding
import javax.inject.Inject

class SplashFragment: Fragment(R.layout.splash_screen) {

    private val binding by viewBinding(SplashScreenBinding::bind)
    private val viewModel : SplashScreenViewModel by viewModels()

}