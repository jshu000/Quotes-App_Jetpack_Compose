package com.andha_coder.firstcompose.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.andha_coder.firstcompose.models.Quote


@Composable
fun QuoteList(data: Array<Quote?>, onClick: (quote:Quote)-> Unit){
    /*Column(modifier = Modifier.fillMaxHeight(1f).fillMaxHeight()) {
        Text(
            text = "Quote App",
            modifier = Modifier.fillMaxWidth(1f),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.padding(4.dp))*/
        LazyColumn(content = {
            items(data){
                if (it != null) {
                    QuoteListItem(quote = it , onClick)
                }
            }
        })
    //}
}