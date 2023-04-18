package com.example.composecurddemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecurddemo.MainActivity.Companion.TAG
import com.example.composecurddemo.ui.theme.ComposeCurdDemoTheme

class MainActivity : ComponentActivity() {
    companion object {
        const val TAG: String = "MainActivity"
    }
    private val  myViewModel= MyViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCurdDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Text(text = "最简单的mvvm")
                        MyScreen(myViewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
@Composable
fun MyScreen(viewModel: MyViewModel) {
    val items by viewModel.items.observeAsState(emptyList())

    Column {
        items.forEach { item ->
            ClickableText(text = AnnotatedString(item),onClick = { Log.e(TAG, "MyScreen: !!!$item")})
        }
        Button(onClick = { viewModel.addItem("New item") }) {
            Text(text = "Add item")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCurdDemoTheme {
        Greeting("Android")
    }
}