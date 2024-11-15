package com.tima.inventory.ui.theme

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.tima.inventory.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                SoundButton()
            }
        }
    }

@Composable
fun SoundButton() {
    val context = LocalContext.current
    var isPlaying by remember { mutableStateOf(false) }

    // Инициализация MediaPlayer с файлом из ресурсов
    val mediaPlayer = remember {
        MediaPlayer.create(context, R.raw.sound) // Замените "sound" на имя вашего файла
    }

    // Настраиваем MediaPlayer так, чтобы сбрасывать состояние после завершения воспроизведения
    DisposableEffect(Unit) {
        mediaPlayer.setOnCompletionListener {
            isPlaying = false // Сброс состояния после завершения звука
        }
        onDispose {
            mediaPlayer.release() // Освобождение ресурсов
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                if (!isPlaying) {  // Проверяем, воспроизводится ли звук
                    mediaPlayer.start()  // Запускаем звук
                    isPlaying = true     // Обновляем состояние, что звук воспроизводится
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Играть звук")
        }
    }
}

const val SOUNDBUTTON_SCREEN = "SoundButton Screen"