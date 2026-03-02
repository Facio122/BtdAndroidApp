package com.example.btdapplication.themes

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.example.btdapplication.themes.Colors.asphalt100
import com.example.btdapplication.themes.Colors.asphalt50
import com.example.btdapplication.themes.Colors.asphalt75
import com.example.btdapplication.themes.Colors.bone
import com.example.btdapplication.themes.Colors.darkAsphalt
import com.example.btdapplication.themes.Colors.green
import com.example.btdapplication.themes.Colors.redUnprofitable

data class BtdColorPalette(
    val primary: Color,
    val darkBackgroundColor: Color,
    val darkOrderBackgroundColor: Color,
    val greenCustomColor: Color,
    val boneTextColor: Color,
    val redUnprofitableColor: Color,
    val greenProfitableColor: Color,
    val rowOrderDarkerColor: Color,
    val rowOrderLighterColor: Color,
    val buttonColors: BtdButtonColors,
)

data class BtdButtonColors(
    val backgroundColor: Color,
    val contentColor: Color,
    val disabledBackgroundColor: Color,
    val disabledContentColor: Color,
)

object BtdColor {

    val palette = BtdColorPalette(
        primary = green,
        darkBackgroundColor = darkAsphalt,
        greenCustomColor = green,
        boneTextColor = bone,
        darkOrderBackgroundColor = asphalt50,
        redUnprofitableColor = redUnprofitable,
        greenProfitableColor = green,
        rowOrderDarkerColor = asphalt75,
        rowOrderLighterColor = asphalt100,
        buttonColors = BtdButtonColors(
            backgroundColor = bone,
            contentColor = darkAsphalt,
            disabledBackgroundColor = asphalt75,
            disabledContentColor = bone,
        )
    )
}

val LocalBtDColorPalette = staticCompositionLocalOf  { BtdColor.palette }