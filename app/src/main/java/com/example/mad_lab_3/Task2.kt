package com.example.mad_lab_3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mad_lab_3.ui.theme.MADlab3Theme

class Task2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADlab3Theme{
                Task2Screen();
            }
        }
    }
}

@Composable
fun Task2Screen(){
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Row(horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                val intent = Intent(context, Login::class.java)
                context.startActivity(intent)
            }) {
                Text(text = "Log in")
            }
            Spacer(modifier = Modifier.size(20.dp))
            Button(onClick = {
                val intent = Intent(context, Signup::class.java)
                context.startActivity(intent)
            }) {
                Text(text = "Sign up")
            }
        }
    }
}