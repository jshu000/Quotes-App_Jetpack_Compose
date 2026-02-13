package com.andha_coder.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.andha_coder.firstcompose.screens.QuoteDetail
import com.andha_coder.firstcompose.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //DataManager.loadAssetFromFile(this)     Running on Main thread so its better to use coroutines
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetFromFile(applicationContext)

            //Data load is happening on IO thread.
            //While Data access is happening on Main Thread. How is this possible ?
            //mutable state change then Quote list screen is displayed.
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    if(DataManager.isDataLoaded.value){
        if(DataManager.currentPage.value== Pages.LISTING){
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        }
        else{
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }
    }
    else {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}

enum class Pages{
    LISTING,
    DETAIL
}