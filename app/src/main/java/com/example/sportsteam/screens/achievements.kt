package com.example.sportsteam.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sportsteam.R
import com.example.sportsteam.visuals.CounterAnimation


@Composable
fun AchievementsScreen() {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC5D3)),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top // items aligned to top
        ) {
            Text(
                text = "Achievements",
                style = MaterialTheme.typography.titleLarge,

                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .padding(top = 30.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.skipping),
                contentDescription = "Picture snoopy skipping",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .padding(bottom = 30.dp)
            )
            Text(
                text = "They have had a 2 game winning streak. Both games were won by default " +
                        "when the other teams didn't show up.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 30.dp)

            )
            Text(
                text = "The worst game they ever played was when they lost " +
                        "six hundred to nothing against the opposing team.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 30.dp)

            )
            Image(
                painter = painterResource(id = R.drawable.team),
                contentDescription = "Picture of the team",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Text(
                text = "Games lost: ",
                style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 10.dp)
            )
            CounterAnimation()
        }
    }
}
