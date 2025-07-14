package com.example.sportsteam.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sportsteam.visuals.LoadImageFromUrl
import com.example.sportsteam.Player
import com.example.sportsteam.R
import com.example.sportsteam.data.players

@Composable
fun HomeScreen(
    favoritePlayers: List<String>,
    onAddToFavorites: (String) -> Unit,
    onPlayerClick: (Player) -> Unit,
) {

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFbdacd1)),
        contentAlignment = Alignment.Center
    ) {
        // making a colum so team players stack
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            players.forEach { player ->
                PlayerRow(
                    player = player,
                    favoritePlayers = favoritePlayers,
                    onAddToFavorites = onAddToFavorites,
                    onPlayerClick = { onPlayerClick(player) }
                )
            }
        }
    }
}

@Composable
fun PlayerRow(
    player: Player,
    favoritePlayers: List<String>,
    onAddToFavorites: (String) -> Unit,
    onPlayerClick: (Player) -> Unit
) {
    val isFavorite = favoritePlayers.contains(player.name)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onPlayerClick(player) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        LoadImageFromUrl(player.imageUrl, 150.dp)

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(text = "Name: ${player.name}")
            Text(text = "Position: ${player.position}")
            FloatingActionButton(
                onClick = { onAddToFavorites(player.name) },
                modifier = Modifier.size(36.dp),
                content = {
                    Image(
                        painter = painterResource(
                        id = if (isFavorite) R.drawable.heartbreak
                        else R.drawable.heart
                    ),
                        contentDescription =
                            if (isFavorite) "Remove from Favourites"
                            else "Add to Favourites",
                        modifier = Modifier.size(24.dp)
                    )
                })
        }
    }
}
