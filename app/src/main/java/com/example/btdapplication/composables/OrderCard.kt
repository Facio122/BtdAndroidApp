package com.example.btdapplication.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btdapplication.themes.LocalBtDColorPalette

@Composable
fun OrderCard(
    botName: String,
    profitCurrency: String,
    profitPercent: String,
    symbol: String,
    status: String,
    orderDate: String,
    sellDate: String,
    isProfit: Boolean,
) {
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .width(300.dp)
            .border(
                width = 1.dp,
                color = if (isProfit) LocalBtDColorPalette.current.greenCustomColor else LocalBtDColorPalette.current.redUnprofitableColor,
                shape = RoundedCornerShape(5.dp)
            )
            .background(color = LocalBtDColorPalette.current.darkOrderBackgroundColor)
            .padding(5.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = spacedBy(20.dp)

        ) {
            BtdText(text = botName)
            ProfitDataContent(
                profitCurrency = "$profitCurrency USD",
                profitPercent = "$profitPercent %",
                symbol = symbol,
                status = status,
                isProfit = isProfit,
            )
            if (status == "FILLED") {
                BtdText(text = "order date: $orderDate", size = 10.sp)
            } else {
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = spacedBy(10.dp)
                ) {
                    DateContent(firstText = "order date", secondText = orderDate)
                    DateContent(firstText = "sell date", secondText = sellDate)
                }
            }
        }
    }
}

@Composable
fun DateContent(firstText: String, secondText: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = spacedBy(3.dp)
    ) {
        BtdText(firstText, size = 10.sp)
        BtdText(secondText, size = 10.sp)
    }
}
@Composable
fun ProfitDataContent(
    profitCurrency: String,
    profitPercent: String,
    symbol: String,
    status: String,
    isProfit: Boolean,
) {
    Row(
        modifier = Modifier.wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = spacedBy(12.dp)
    ) {
        val color = if (isProfit) LocalBtDColorPalette.current.greenCustomColor else LocalBtDColorPalette.current.redUnprofitableColor

        BtdText(text = profitCurrency, color = color)
        BtdText(text = profitPercent, color = color)
        BtdText(text = symbol)
        BtdText(text = status)
    }
}

@Composable
@Preview
fun PreviewFilledOrderCard() {
    OrderCard(
        botName = "STRATEGY 1",
        profitCurrency = "0.49",
        profitPercent = "2.34",
        symbol = "DOGEUSD",
        status = "FILLED",
        orderDate = "14.09.2025 05:47:39",
        sellDate = "15.09.2025 02:44:39",
        true
    )
}

@Composable
@Preview
fun PreviewSoldOrderCard() {
    OrderCard(
        botName = "STRATEGY 1",
        profitCurrency = "0.49",
        profitPercent = "2.34",
        symbol = "UNIUSD",
        status = "MARKET SOLD",
        orderDate = "14.09.2025 05:47:39",
        sellDate = "15.09.2025 06:43:39",
        true
    )
}

@Composable
@Preview
fun PreviewSoldUnprofitableOrderCard() {
    OrderCard(
        botName = "STRATEGY 1",
        profitCurrency = "-0.49",
        profitPercent = "-2.34",
        symbol = "UNIUSD",
        status = "MARKET SOLD",
        orderDate = "14.09.2025 05:47:39",
        sellDate = "15.09.2025 06:43:39",
        false,
    )
}