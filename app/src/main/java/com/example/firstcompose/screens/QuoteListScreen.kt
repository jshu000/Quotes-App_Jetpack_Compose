package com.example.firstcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.firstcompose.models.Quote

@Composable
fun QuoteListScreen(data:Array<Quote?>,onClick:()-> Unit) {
    Column(modifier = Modifier
        .fillMaxHeight(1f)
        .fillMaxHeight()) {
        Text(
            text = "Quotes App",
            //style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(8.dp,24.dp)
                .fillMaxWidth(1f),
            textAlign = TextAlign.Center,
        )
        QuoteList(data = data) {
            onClick
        }
    }
}