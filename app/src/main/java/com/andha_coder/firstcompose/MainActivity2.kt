package com.andha_coder.firstcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App2()
        }
    }
}


fun a() {
    Log.d("Jashwant", "I am A from App")
}

fun b() {
    Log.d("Jashwant", "I am B from App")
}

@Composable
fun App2() {
    var state = remember { mutableStateOf(::a) }

    Button(onClick = { state.value = ::b }) {
        Text(text = "Click to change state")
    }

    LandingScreen(state.value)
}

@Composable
fun LandingScreen(onTimeout: () -> Unit) {
    val currentOnTimeout by rememberUpdatedState(onTimeout)

    LaunchedEffect(true) {
        delay(5000)
        currentOnTimeout()
    }
}
