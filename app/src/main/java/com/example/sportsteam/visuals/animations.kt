package com.example.sportsteam.visuals

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import com.example.sportsteam.R


@Composable
fun FadeAnimation() {
    var isFirstColour by remember { mutableStateOf(true) }
    val woodstock_warm = R.drawable.warm
    val woodstock_cold = R.drawable.cold
    val color by animateColorAsState(
        targetValue = if (isFirstColour) Color.Red else Color(0xFF33BEFF),
        animationSpec = tween(durationMillis = 1000) // Optional: specify animation duration
    )
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color)
            .clickable { isFirstColour = !isFirstColour },
        contentAlignment = Alignment.Center
    ) {
         Image(
            painter = painterResource(id = if (isFirstColour) woodstock_warm
            else woodstock_cold),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
    }
}

@Composable
fun CounterAnimation(){
    Row(Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        var count by remember { mutableIntStateOf(0) }
        Button(onClick = { count++ }) {
            Text("+")
        }
        Button(onClick = { count-- }) {
            Text("-")
        }
        AnimatedContent(
            targetState = count,
            transitionSpec = {
                if (targetState > initialState) {
                    slideInVertically { height -> height } + fadeIn() togetherWith
                            slideOutVertically { height -> -height } + fadeOut()
                } else {
                    slideInVertically { height -> -height } + fadeIn() togetherWith
                            slideOutVertically { height -> height } + fadeOut()
                }.using(
                    SizeTransform(clip = false)
                )
            }, label = "animated content"
        ) { targetCount ->
            Text(text = " $targetCount")
        }
    }
}

@Composable
fun SnackAnimation() {
    var visible by remember { mutableStateOf(true) }
    val density = LocalDensity.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = { visible = !visible }) {
            Text(if (visible) "Hide Snack" else "Show Snack")
        }
        Spacer(modifier = Modifier.height(30.dp))
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically {
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                expandFrom = Alignment.Top
            ) + fadeIn(
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            Image(
                painter = painterResource(id = R.drawable.toastie),
                contentDescription = "Sandwich",
                modifier = Modifier.size(100.dp),
            )
            Spacer(modifier = Modifier.height(20.dp))


        }
    }
    Image(
        painter = painterResource(
            id = if (visible) R.drawable.happy else R.drawable.sad
        ),
        contentDescription = if (visible) "Snoopy happy" else "Snoopy sad",
        modifier = Modifier
            .padding(top = 470.dp)
            .padding(bottom = 20.dp)
            .size(250.dp),
    )
}