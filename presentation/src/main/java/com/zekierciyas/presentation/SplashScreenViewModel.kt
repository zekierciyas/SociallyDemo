package com.zekierciyas.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(): ViewModel() {

    private val _splashState = MutableStateFlow<SplashState>(SplashState.SplashEmpty)
    val splashState: StateFlow<SplashState> = _splashState


    fun updateSplashState() {
        viewModelScope.launch {
            when(splashState.value) {
                SplashState.SplashEmpty -> {
                    _splashState.value = SplashState.SplashV1
                }
                 SplashState.SplashV1 -> {
                     _splashState.value = SplashState.SplashV2
                }

                SplashState.SplashV2 -> {
                    _splashState.value = SplashState.SplashV3
                }

                SplashState.SplashV3 -> {
                }
            }
        }
    }
}

sealed class SplashState {
    object SplashEmpty: SplashState()
    object SplashV1: SplashState()
    object SplashV2: SplashState()
    object SplashV3: SplashState()
}