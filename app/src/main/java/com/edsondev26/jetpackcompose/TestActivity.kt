package com.edsondev26.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edsondev26.jetpackcompose.ui.theme.JetpackComposeTheme

class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test()
        }
    }
}

@Composable
fun Test(){
    JetpackComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Greeting(
                name = "Edson",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "ESTA ES UNA PANTALLA PRUEBA"
    )
}

@Preview(showBackground = true)
@Composable
fun ExampleModifier() {
    Text(text = "Tutorial", Modifier.padding(horizontal = 16.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        Greeting("Edson")
    }
}

@Preview(showBackground = true)
@Composable
fun SecondPreview() {
    JetpackComposeTheme {
        Greeting("Edson 2")
    }
}