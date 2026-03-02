package com.example.btdapplication.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.btdapplication.themes.LocalBtDColorPalette

@Composable
fun BtdText(
    text: String = "",
    size: TextUnit = 13.sp,
    color: Color = LocalBtDColorPalette.current.boneTextColor,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null,
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontSize = size,
        textAlign = textAlign,
    )
}