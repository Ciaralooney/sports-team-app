package com.example.sportsteam.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sportsteam.R
import com.example.sportsteam.visuals.SnackAnimation
import com.example.sportsteam.visuals.FadeAnimation


@Composable
fun FavouritesScreen(
    favoritePlayers: List<String>,
    onRemoveFromFavorites: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFADD8E6))
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        if (favoritePlayers.isEmpty()) {
            Text(text = "No favourite players yet")
            Image(
                painter = painterResource(id = R.drawable.asleep),
                contentDescription = "Snoopy asleep",
                modifier = Modifier
                    .size(250.dp)
                    .padding(top = 100.dp) // Add some space below the image
            )
            SnackAnimation()
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart) // bottom left
                    .padding(16.dp)
            ) {
                FadeAnimation()
            }
        } else {
            LazyColumn {
                items(favoritePlayers) { player ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Replace with the correct drawable resource id for each player
                        val playerImageId = when (player) {
                            "Snoopy" -> R.drawable.snoopy
                            "Charlie Brown" -> R.drawable.charlie_brown
                            "Franklin" -> R.drawable.franklin
                            "Linus" -> R.drawable.linus
                            "Lucy" -> R.drawable.lucy
                            "Marcie" -> R.drawable.marcie
                            "Peppermint Patty" -> R.drawable.peppermint_patty
                            "Sally" -> R.drawable.sally
                            "Schroeder" -> R.drawable.schroeder
                            "Woodstock" -> R.drawable.woodstock
                            else -> R.drawable.team
                        }
                        Image(
                            painter = painterResource(id = playerImageId),
                            contentDescription = "image of $player",
                            modifier = Modifier.size(80.dp)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        // Display player's name
                        Text(text = player, modifier = Modifier.weight(1f))

                        FloatingActionButton(
                            onClick = { onRemoveFromFavorites(player) },
                            modifier = Modifier.size(36.dp),
                            content = {
                                Image(
                                    painter = painterResource(id = R.drawable.heartbreak),
                                    contentDescription = "Remove from Favourites",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

