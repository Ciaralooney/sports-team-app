package com.example.sportsteam.visuals

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun LoadImageFromUrl(imageUrl: String, imageSize: Dp) {
    Box(modifier = Modifier.size(imageSize), contentAlignment = Alignment.Center) {
        // Display CircularProgressIndicator while loading the image
        CircularProgressIndicator(color = Color.Gray)

        // Load image from URL
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl) // url with the image
                .crossfade(true)
                .build(),
            contentDescription = "Image from URL",// content description
            modifier = Modifier.size(imageSize), // set image size
            contentScale = ContentScale.Fit// set content scale
        )
    }
}