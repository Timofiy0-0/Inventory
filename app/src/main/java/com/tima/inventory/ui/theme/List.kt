package com.tima.inventory.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.CompositingStrategy.Companion.Auto
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.Hyphens.Companion.Auto

data class Car(
    var tipe: String?,
    var year: Long?,
    var company: String?,
    var engine: String?,
    var conditioner: Boolean?,
    var prise: Long?,
)

@Composable
fun Listscreen() {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        var list by rememberSaveable { mutableStateOf(listOf<Car>()) }

        var company by rememberSaveable { mutableStateOf(value = "") }
        var tipe by rememberSaveable { mutableStateOf(value = "") }
        var year by rememberSaveable { mutableStateOf(value = "") }
        var engine by rememberSaveable { mutableStateOf(value = "") }
        var conditioner by rememberSaveable { mutableStateOf(value = false) }
        var prise by rememberSaveable { mutableStateOf(value = "") }

        TextField(company, { company = it }, label = { Text(text = "производитель") })
        TextField(tipe, { tipe = it }, label = { Text(text = "тип") })
        TextField(year, { year = it }, label = { Text(text = "год") })
        TextField(engine, { engine = it }, label = { Text(text = "мотор") })
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(conditioner, { conditioner = it })
            Text(text = "наличие кондиционера")
        }
        TextField(prise,
            { prise = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "цена") })
        Button(onClick = {
            val car =
                Car(tipe, year.toLongOrNull(), company, engine, conditioner, prise.toLongOrNull())
            list = list + car
        }) { Text(text = "Добавить") }
        LazyColumn(Modifier.fillMaxSize()) {
            items(list) { car ->
                Text(text = "${car.tipe} ${car.year} ${car.company} ${car.engine} Conditioner: ${if (car.conditioner == true) "Есть" else "Нету"} ${car.prise}")
            }
        }
    }
}

val LIST_SCREEN = "List Screen"