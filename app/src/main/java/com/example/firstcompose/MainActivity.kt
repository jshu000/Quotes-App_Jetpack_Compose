package com.example.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcompose.screens.ScheduleListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //DataManager.loadAssetFromFile(this)     Running on Main thread so its better to use coroutines
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetFromFile2(applicationContext)

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
    if( DataManager.isDataLoaded2.value){
        if(DataManager.currentPage2.value== Pages.LISTING){
            ScheduleListScreen(data = DataManager.data2, data5 = DataManager.data5) {
                DataManager.switchPages2(it)
            }
        }
        else{
            //DataManager.currentQuote?.let { QuoteDetail(quote = it) }
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