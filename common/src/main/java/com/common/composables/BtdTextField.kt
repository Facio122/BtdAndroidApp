package com.common.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.common.themes.Colors.darkGrey100
import com.common.themes.Colors.darkGrey75
import com.common.themes.LocalBtDColorPalette

@Composable
fun BtdTextField(label: String = "", placeholder: String = "") {

    var filledText by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .width(300.dp)
            .border(1.dp, darkGrey75, shape = RoundedCornerShape(corner = CornerSize(8.dp)))
        ,
        value = filledText,
        onValueChange = { filledText = it },
        label = { BtdText(label, color = darkGrey100) },
        placeholder = { BtdText(placeholder, color = darkGrey75) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = LocalBtDColorPalette.current.darkBackgroundColor,
            unfocusedContainerColor = LocalBtDColorPalette.current.darkBackgroundColor,
            focusedTextColor = LocalBtDColorPalette.current.boneTextColor,
        ),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
    )
}

@Composable
@Preview
fun BtdTextFieldPreview() {
    BtdTextField(
        label = "Label",
        placeholder = "Placeholder"
    )
}