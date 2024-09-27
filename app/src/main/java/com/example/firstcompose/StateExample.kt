package com.example.firstcompose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun NotificationScreen(){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)) {

        NotificationCounter();
    }
}

@Composable
fun NotificationCounter() {
    var counter: MutableState<Int> = remember{mutableStateOf(0)}
    Column(verticalArrangement = Arrangement.Center) {
        Text(text = "Total Notification sent is ${counter.value}")
        Button(onClick = {
            counter.value++
            Log.d("jashwant", "NotificationCounter: Button Clicked")
        }) {
            Text(text = "Send Notification")
        }
    }
}
