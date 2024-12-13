package com.andha_coder.firstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun NotificationScreen(){

    //State full composable .
    //As one state is defined in this function

    //Data Flow happens in unidirectional
    //It will pass to the two child functions(notificationCounter and messagebar)
    //Top to down
    var counter: MutableState<Int> = rememberSaveable{mutableStateOf(0)}
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)) {

        NotificationCounter(counter.value, { counter.value++ });
        MessageBar(counter.value)
    }
}

@Composable
fun NotificationCounter(count: Int, increment: () -> Int) {
    //Stateless composable .
    //As No state is defined in this function.

    //While Event flow happens from down to top

    Column(verticalArrangement = Arrangement.Center) {
        Text(text = "Total Notification sent is ${count}")
        Button(onClick = {increment()
        }) {
            Text(text = "Send Notification")
        }
    }
}

@Composable
fun MessageBar(count: Int) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "",
                Modifier.padding(4.dp)
            )
            Text(text = "Messages sent so far - $count")
        }
    }
}

