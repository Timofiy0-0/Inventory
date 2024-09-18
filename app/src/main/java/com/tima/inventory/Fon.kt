package com.tima.inventory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@Composable
fun FonScreen() {
    var kolir by remember { mutableStateOf(Color.White) }
    Column(

        Modifier
            .background(kolir)
            .fillMaxSize()
    ) {
        Button({ kolir = Color.Red }) {
            Text(text = "Красный")
        }
        Button({ kolir = Color.Yellow }) {
            Text(text = "Жёлтый")
        }
        Button({ kolir = Color.Green }) {
            Text(text = "Зелёный")
        }
        Row {
            Button({ kolir = Color.Blue }) {
                Text(text = "Синий")
            }
            Button({ kolir = getRandomColor() }) {
                Text(text = "?")
            }

        }
    }
}
val FON_SCREEN = "fon screen"
fun getRandomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 1f
    )
}









