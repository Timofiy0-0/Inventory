package com.tima.inventory.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import java.sql.Date
import java.sql.Time
import java.text.SimpleDateFormat

const val Time_SCREEN = "Time screen"

@Composable
fun TimeScreen() {
    Column(Modifier.fillMaxSize()) {
        var result by rememberSaveable { mutableStateOf("") }
        Button({
            result = SimpleDateFormat("HH:mm:ss").format(Date(System.currentTimeMillis()))
        }) { Text("Узнать время") }
        Text(result, fontSize = 30.sp)


    }
}