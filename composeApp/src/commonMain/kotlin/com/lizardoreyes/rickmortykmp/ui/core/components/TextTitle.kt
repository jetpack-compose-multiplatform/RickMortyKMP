package com.lizardoreyes.rickmortykmp.ui.core.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.lizardoreyes.rickmortykmp.ui.core.DefaultTextColor
import org.jetbrains.compose.resources.Font

@Composable
fun TextTitle(text: String) {
    Text(text.uppercase(), color = DefaultTextColor, fontWeight = FontWeight.Bold)
}