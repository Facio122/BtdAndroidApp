package com.example.btdapplication.presentation

import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btdapplication.composables.BtdSheetDragHandle
import com.example.btdapplication.composables.BtdText
import com.example.btdapplication.themes.LocalBtDColorPalette


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomDrawer(
    isProfit: Boolean,
    profitCurrency: Double,
) {
    BottomSheetScaffold(
        modifier = Modifier
            .wrapContentSize(),
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = spacedBy(8.dp)
            ) {
                BtdText(
                    text = if (isProfit) "ZAROBIŁO" else "UCIEKŁO",
                    color = LocalBtDColorPalette.current.boneTextColor,
                    size = 20.sp
                )
                BtdText(
                    text = "$profitCurrency USD",
                    color = if (isProfit) LocalBtDColorPalette.current.greenProfitableColor else LocalBtDColorPalette.current.redUnprofitableColor,
                    size = 30.sp
                )
            }
        },
        sheetPeekHeight = 35.dp,
        sheetShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
        sheetContainerColor = LocalBtDColorPalette.current.darkOrderBackgroundColor,
        sheetDragHandle = {
            BtdSheetDragHandle()
        }
    ) {

    }
}

@Composable
@Preview
fun PreviewBottomDrawerWithProfitableValue() {
    BottomDrawer(
        isProfit = true,
        profitCurrency = 0.49
    )
}

@Composable
@Preview
fun PreviewBottomDrawerWithUnprofitableValue() {
    BottomDrawer(
        isProfit = false,
        profitCurrency = -0.49
    )
}