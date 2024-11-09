package com.edsondev26.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItem by remember { mutableStateOf(0) }

    NavigationDrawer(
        drawerState = drawerState,
        selectedItem = selectedItem,
        onItemSelected = { selectedItem = it },
        onDrawerClick = { scope.launch { drawerState.close() } }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Compose App") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                when (selectedItem) {
                    0 -> HomeScreen()
                    1 -> ProfileScreen()
                    2 -> TestScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(
    drawerState: DrawerState,
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
    onDrawerClick: () -> Unit,
    content: @Composable () -> Unit
) {
    val items = listOf(
        NavigationItem(
            title = "Home",
            icon = Icons.Default.Home
        ),
        NavigationItem(
            title = "Perfil",
            icon = Icons.Default.Person
        ),
        NavigationItem(
            title = "Test",
            icon = Icons.Default.Face
        )
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        icon = { Icon(item.icon, contentDescription = item.title) },
                        label = { Text(item.title) },
                        selected = selectedItem == index,
                        onClick = {
                            onItemSelected(index)
                            onDrawerClick()
                        }
                    )
                }
            }
        }
    ) {
        content()
    }
}

data class NavigationItem(
    val title: String,
    val icon: ImageVector
)

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 4.dp),
            text = "HOME",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ProfileScreen() {
    ViewContainer()
}

@Composable
fun TestScreen() {
    Test()
}