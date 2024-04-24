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

class Signup : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADlab3Theme{
                SignupScreen();
            }
        }
    }
}

@Composable
fun SignupScreen(){
    val context = LocalContext.current
    val nameValue = remember { mutableStateOf("") }
    val emailValue = remember{ mutableStateOf("") }
    val password = remember{ mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = nameValue.value,
            onValueChange = { nameValue.value = it},
            label = { Text(text = "Fullname") }
        )
        Spacer(modifier = Modifier.size(10.dp))
        TextField(
            value = emailValue.value,
            onValueChange = { emailValue.value = it},
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
            Text(text = "Register")
        }
        Spacer(modifier = Modifier.size(50.dp))
        Text(
            text = "Already registered! Login Me.",
            modifier = Modifier.clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                val intent = Intent(context, Login::class.java)
                context.startActivity(intent)
            }
        )
    }
}
