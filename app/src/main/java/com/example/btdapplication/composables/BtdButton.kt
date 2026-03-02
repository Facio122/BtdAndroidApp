package com.example.btdapplication.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btdapplication.themes.LocalBtDColorPalette


@Composable
fun btdButtonColors() = ButtonColors(
    containerColor = LocalBtDColorPalette.current.buttonColors.backgroundColor,
    contentColor = LocalBtDColorPalette.current.buttonColors.contentColor,
    disabledContainerColor = LocalBtDColorPalette.current.buttonColors.disabledBackgroundColor,
    disabledContentColor = LocalBtDColorPalette.current.buttonColors.disabledContentColor,
)
@Composable
fun BtdButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    colors: ButtonColors = btdButtonColors(),
    content: @Composable () -> Unit = {},
) {
    Button(
        shape = RoundedCornerShape(3.dp),
        modifier = modifier,
        colors = colors,
        onClick = { onClick() },
        enabled = true,
        contentPadding = PaddingValues(horizontal = 6.dp)
    ) {
        content()
    }
}

@Composable
@Preview
fun BtdButtonPreview() {
    BtdButton(
        content = { BtdText(text = "Click Me!", color = LocalBtDColorPalette.current.darkBackgroundColor) }
    )
}