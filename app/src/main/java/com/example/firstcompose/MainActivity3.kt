package com.example.firstcompose


import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.delay

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //App3()
            //MediaComposable()
            KeyboardComposable()
            TextField(value = "", onValueChange = {})
        }
    }
}

@Composable
fun KeyboardComposable() {
    val view = LocalView.current

    DisposableEffect(key1 = Unit) {
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val insets = ViewCompat.getRootWindowInsets(view)
            val isKeyboardVisible = insets?.isVisible(WindowInsetsCompat.Type.ime())==true
            Log.d("jashwant", isKeyboardVisible.toString())
        }

        view.viewTreeObserver.addOnGlobalLayoutListener(listener)

        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }
    }

}



@Composable
fun App3() {
    var state = remember { mutableStateOf(false) }

    DisposableEffect(key1 = state.value) {
        Log.d("jashwant", "Disposable Effect Started")
        onDispose {
            Log.d("jashwant", "Cleaning up side effects")
        }
    }

    Button(onClick = { state.value = !state.value }) {
        Text(text = "Change State")
    }
}

@Composable
fun MediaComposable() {
    val context = LocalContext.current

    DisposableEffect(Unit) {
        val mediaPlayer = MediaPlayer.create(context, R.raw.song)
        mediaPlayer.start()

        onDispose {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }
}
