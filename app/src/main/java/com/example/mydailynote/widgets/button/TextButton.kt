package com.example.mydailynote.widgets.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,

    textColor: Color = MaterialTheme.colorScheme.onPrimary,


    ) {
    TextButton(
        onClick = onClick,


        ) {
        Text(
            text = text, color = textColor,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold,

                )
        )

    }
}