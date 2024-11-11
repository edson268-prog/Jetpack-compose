package com.edsondev26.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.edsondev26.jetpackcompose.ui.login.ui.LoginScreen
import com.edsondev26.jetpackcompose.ui.login.ui.LoginViewModel

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginScreen(LoginViewModel(), this)
        }
    }
}