package com.example.mad_lab_3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mad_lab_3.ui.theme.MADlab3Theme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADlab3Theme{
                LoginScreen();
            }
        }
    }
}

@Composable
fun LoginScreen(){
    val context = LocalContext.current
    val textFieldValue = remember{ mutableStateOf("") }
    val password = remember{ mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = textFieldValue.value,
            onValueChange = { textFieldValue.value = it},
            label = { Text(text = "Email") }
        )
        Spacer(modifier = Modifier.size(10.dp))
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(), // Hide password input
        )
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

        ) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.size(50.dp))
        Text(
            text = "Not a member? Sign up now.",
            modifier = Modifier.clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                val intent = Intent(context, Signup::class.java)
                context.startActivity(intent)
            }
        )
    }
}
