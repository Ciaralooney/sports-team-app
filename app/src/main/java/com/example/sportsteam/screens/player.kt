package com.example.sportsteam.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sportsteam.visuals.LoadImageFromUrl

@Composable
fun PlayerDetailScreen(
    playerName: String,
    imageUrl: String,
    position: String,
    sandwich: String,
    fact: String,
    onBackClick: () -> Unit
) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFbdacd1))
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier.verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally) {
            LoadImageFromUrl(imageUrl, 400.dp)  // Display player's image
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = playerName, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Position: $position", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Favourite Sandwich: $sandwich", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Fun Fact: $fact", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = onBackClick) {
                Text(text = "Back")
            }
        }
    }
}