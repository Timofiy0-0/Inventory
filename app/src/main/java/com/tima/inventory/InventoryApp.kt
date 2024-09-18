package com.tima.inventory

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun InventoryScreen(navController: NavHostController) {

}

@Composable
fun AddItemScreen(navController: NavHostController) {
    var name by rememberSaveable { mutableStateOf("") }
    var surname by rememberSaveable { mutableStateOf("") }
    var result by rememberSaveable { mutableStateOf("") }
    Column {
        TextField(value = name, onValueChange = { name = it })
        TextField(value = surname, onValueChange = { surname = it })
        Button(onClick = { result = "$name $surname" }) {
            Text(text = "Анука что там будет")
        }
        Text(text = result, fontSize = 50.sp)
    }
}

@Composable
fun EditItemScreen(navController: NavHostController) {

}

@Composable
fun ItemDetailsScreen(navController: NavHostController) {

}

const val INVENTORY_SCREEN = "Inventory"
const val ADD_ITEM_SCREEN = "Add Item"
const val EDIT_ITEM_SCREEN = "Edit Item"
const val ITEM_DETAILS_SCREEN = "Item Details"