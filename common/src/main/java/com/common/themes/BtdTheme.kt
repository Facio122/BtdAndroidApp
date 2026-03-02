package com.common.themes

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.common.themes.Colors.asphalt100
import com.common.themes.Colors.asphalt50
import com.common.themes.Colors.asphalt75
import com.common.themes.Colors.bone
import com.common.themes.Colors.darkAsphalt
import com.common.themes.Colors.green
import com.common.themes.Colors.redUnprofitable

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