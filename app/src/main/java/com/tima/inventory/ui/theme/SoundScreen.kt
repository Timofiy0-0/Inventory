package com.tima.inventory.ui.theme

import android.media.MediaPlayer
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.tima.inventory.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@Composable
fun SoundScreen() {
    val context = LocalContext.current
    var isPlaying by remember { mutableStateOf(false) }

    // Подключаем файл звука из ресурсов
    val mediaPlayer = remember {
        MediaPlayer.create(context, R.raw.sound) // замените sound на имя вашего файла
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { isPlaying = !isPlaying },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = if (isPlaying) "Стоп" else "Играть звук")
        }
    }

    // Эффект для проигрывания звука с заданным интервалом
    LaunchedEffect(isPlaying) {
        while (isPlaying && isActive) {
            mediaPlayer.start() // Запускаем звук
            delay(1000) // Интервал в 0.5 секунды
            mediaPlayer.pause() // Останавливаем, если нужно обрывать звук
            mediaPlayer.seekTo(0) // Возвращаемся к началу звука
        }
    }

    // Освобождаем ресурсы при завершении
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }
}

const val SOUND_SCREEN = "Sound Screen"