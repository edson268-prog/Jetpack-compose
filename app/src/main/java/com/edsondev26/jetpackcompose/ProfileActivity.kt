package com.edsondev26.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewContainer()
        }
    }
}

@Preview
@Composable
fun ViewContainer() {
    Scaffold(
        topBar = { Toolbar() },
        floatingActionButton = { FAB() },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        Content(modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun FAB() {
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context, "Prueba de botón", Toast.LENGTH_SHORT).show()
    }) {
        Text("X")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text(text = "Perfil de Edson", color = colorResource(id = R.color.white)) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.gray)
        )
    )
}

//@Preview
@Composable
fun Content(modifier: Modifier = Modifier) {
    var counter by rememberSaveable() { mutableStateOf(0) }

    LazyColumn(
        modifier = modifier.then(
            Modifier
                .fillMaxSize()
                .background(Color.Blue)
        )
    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                painter = painterResource(id = R.drawable.banner_4),
                contentDescription = "logo banner",
                contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier.padding(top = 8.dp, start = 16.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Like",
                    modifier = Modifier.clickable { counter++ }
                )

                Text(
                    text = counter.toString(),
                    color = Color.White,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
            Text(
                text = "Perfil de Edson",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 4.dp),
                textAlign = TextAlign.Center
            )
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                item {
                    Text(text = "Stack", color = Color.White)
                    Text(text = "Java", color = Color.White)
                    Text(text = "Kotlin", color = Color.White)
                    Text(text = "Net", color = Color.White)
                    Text(
                        text = "ESTE ES UN TEXTO LARGO QUE DEBERIA USAR MAS ESPACION DEL QUE DISPONE LA PANTALLA POR TAL, EL ROW VA A SER SCROLLEABLE",
                        color = Color.White
                    )
                }
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Fullstack Developer", color = Color.White)
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "9 Años experiencia", color = Color.White)
            }

        }
    }
}