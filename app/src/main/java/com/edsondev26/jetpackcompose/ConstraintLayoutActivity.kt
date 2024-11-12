package com.edsondev26.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

class ConstraintLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BoxConstraint()
        }
    }
}

@Preview
@Composable
fun BoxConstraint() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (boxRed, boxBlue, boxGreen, boxMagenta, boxYellow, boxWhite, boxBlack) = createRefs()

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    top.linkTo(boxRed.bottom)
                    start.linkTo(boxRed.end, margin = 10.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    top.linkTo(boxBlue.bottom)
                    start.linkTo(parent.start)
                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    top.linkTo(boxGreen.bottom)
                    start.linkTo(boxGreen.end, margin = 16.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    top.linkTo(boxMagenta.bottom)
                    start.linkTo(parent.start)
                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.White)
                .constrainAs(boxWhite) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Black)
                .constrainAs(boxBlack) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )

        createHorizontalChain(boxWhite, boxBlack, chainStyle = ChainStyle.Spread)
    }
}