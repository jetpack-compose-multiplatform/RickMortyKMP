package com.lizardoreyes.rickmortykmp

import androidx.compose.ui.window.ComposeUIViewController
import com.lizardoreyes.rickmortykmp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }