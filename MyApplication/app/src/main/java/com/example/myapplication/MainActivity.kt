package com.example.myapplication

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
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val scheduler = AndroidAlarmScheduler(this)
        var alarmItem: AlarmItem? = null

        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )

                        var secondsText by remember { mutableStateOf("") }
                        var message by remember { mutableStateOf("") }

                        // ... rest of your UI elements (OutlinedTextField, Button, etc.) ...

                        Button(onClick = {
                            alarmItem = AlarmItem(
                                time = LocalDateTime.now()
                                    .plusSeconds(secondsText.toLong()),
                                message = message
                            )
                            alarmItem?.let(scheduler::schedule)
                            secondsText = ""
                            message = ""
                        }) {
                            Text(text = "Schedule")
                        }

                        // ... rest of your UI elements ...
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}