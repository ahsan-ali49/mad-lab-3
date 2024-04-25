package com.example.mad_lab_3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mad_lab_3.ui.theme.MADlab3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADlab3Theme {
                MainPage()
            }
        }
    }
}

@Composable
fun MainPage() {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "MAD Lab 3",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.size(50.dp))
            Button(onClick = {
                val intent = Intent(context, Task1::class.java)
                context.startActivity(intent)
            }) {
                Text(text = "Activity Experiment")
            }
            Spacer(modifier = Modifier.size(20.dp))
            Button(onClick = {
                val intent = Intent(context, Task2::class.java)
                context.startActivity(intent)
            }) {
                Text(text = "Task 2")
            }
            Spacer(modifier = Modifier.size(20.dp))
            Button(onClick = {
                val intent = Intent(context, Task3::class.java)
                context.startActivity(intent)
            }) {
                Text(text = "Task 3")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MADlab3Theme {
        MainPage()
    }
}