package com.lizardoreyes.rickmortykmp.ui.core.ext

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import com.lizardoreyes.rickmortykmp.ui.core.Green

fun Modifier.vertical() = layout { measurable, constraints ->
    // Contains the coordinates of the child
    val placeable = measurable.measure(constraints)
    layout(placeable.height, placeable.width) {
        placeable.place(
            x = -((placeable.width / 2) - (placeable.height / 2)),
            y = -((placeable.height / 2) - (placeable.width / 2))
        )
    }
}

fun Modifier.aliveBorder(isAlive: Boolean): Modifier {
    val color = if (isAlive) Green else Color.Red
    return border(4.dp, color, CircleShape)
}