package com.example.firstcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.firstcompose.screens.ScheduleListScreen
import com.example.firstcompose.viewmodels.MainViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProvider(this).get(MainViewModel::class)

        setContent {
            App(viewModel = viewModel as MainViewModel)
        }

    }
}

@Composable
fun App(viewModel: MainViewModel) {
    Log.d("jashwantcompose", "App: recompose happening ")
    val schedules = viewModel.schedules.observeAsState()
    val teams = viewModel.teams.observeAsState()
    if(schedules!=null && teams != null) {
        ScheduleListScreen(data = viewModel) {
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
