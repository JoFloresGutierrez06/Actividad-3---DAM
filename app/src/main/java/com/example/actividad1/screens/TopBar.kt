package com.example.actividad1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.statusBarsPadding

private val Pink = Color(0xFFDB5461)

@Composable
fun TopBar(
    title: String,
    onBack: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Pink)
            .statusBarsPadding()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (onBack != null) {
            Text(
                text = "<",
                color = Color.White,
                modifier = Modifier
                    .clickable {
                        onBack()
                    }
                    .padding(end = 16.dp)
            )
        }

        Text(
            text = title,
            color = Color.White
        )
    }
}