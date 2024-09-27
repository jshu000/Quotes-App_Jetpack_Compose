package com.example.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //previewItem()
            NotificationScreen()
        }
    }
}
/*

@Preview
@Composable
private fun Previewfunction(){
    Column {
        ListViewItem(R.drawable.man,"Jashwant","Software Developer")
        ListViewItem(R.drawable.man,"Jashwant","Software Developer")
        ListViewItem(R.drawable.man,"Jashwant","Software Developer")
        ListViewItem(R.drawable.man,"Jashwant","Software Developer")
    }
}

@Composable
fun ListViewItem(imgid :Int,name :String, role: String) {
    Row(Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(imgid),
            contentDescription = "Dummy pic",
            Modifier.size(40.dp)
        )
        Column {
            Text(text = name)
            Text(text = role)
        }
    }
}

@Preview(showBackground = true, name = "preview")
@Composable
fun sayhello(name: String = "jashwant") {
    Text(text = "Hellooooo $name")
}

@Preview(showBackground = true, name = "preview2")
@Composable
fun sayhello2(name: String = "jashwantttt") {
    Text(text = "Hellooooo $name")
}

*/
