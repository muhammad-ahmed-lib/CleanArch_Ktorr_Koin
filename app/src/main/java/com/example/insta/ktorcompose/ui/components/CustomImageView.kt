package com.example.insta.ktorcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource


@Composable
fun CustomImageView(
    url:String="",
    imageResource: Int,
    contentScale: ContentScale = ContentScale.Crop,
    imageColor: Color? = null,
    modifier: Modifier = Modifier
) {
    Image(
        painter =painterResource(id = imageResource),
        contentDescription = "",
        contentScale = contentScale,
        colorFilter = imageColor?.let { ColorFilter.tint(it) }, // Apply color filter if imageColor is not null
        modifier = modifier
    )
}
