package com.example.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcompose.ui.theme.FirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Text(text = "Hello Jashwant")
        }
    }
}

@Preview(showBackground = true, name = "preview")
@Composable
fun sayhello(name:String="jashwant"){
    Text(text = "Hellooooo $name")
}

@Preview(showBackground = true, name = "preview2")
@Composable
fun sayhello2(name:String="jashwantttt"){
    Text(text = "Hellooooo $name")
}

