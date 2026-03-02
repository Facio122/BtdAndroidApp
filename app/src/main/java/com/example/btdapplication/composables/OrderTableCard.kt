package com.example.btdapplication.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btdapplication.data.OrderData
import com.example.btdapplication.data.OrderStatus
import com.example.btdapplication.themes.LocalBtDColorPalette

@SuppressLint("DefaultLocale")
@Composable
fun OrderTableCard(
    orders: List<OrderData>,
    isProfit: Boolean,
    profitCurrency: Double,
) {
    val formattedProfit = String.format("%.2f", profitCurrency)

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .width(300.dp)
            .border(
                width = 1.dp,
                color = if (isProfit) LocalBtDColorPalette.current.greenCustomColor else LocalBtDColorPalette.current.redUnprofitableColor,
                shape = RoundedCornerShape(3.dp)
            )
            .background(color = LocalBtDColorPalette.current.darkOrderBackgroundColor)
            .padding(vertical = 5.dp, horizontal = 2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BtdText(modifier = Modifier.weight(0.8f), text = "P&L")
            BtdText(modifier = Modifier.weight(0.7f), text = "Profit")
            BtdText(modifier = Modifier.weight(1f), text = "Symbol")
            BtdText(modifier = Modifier.weight(1f), text = "Status")
        }
        Spacer(modifier = Modifier.padding(vertical = 3.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            orders.forEachIndexed { index, order ->
                val color = if (index%2 == 0) LocalBtDColorPalette.current.rowOrderDarkerColor else LocalBtDColorPalette.current.rowOrderLighterColor
                OrderRow(order, color)
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 3.dp))
        BtdText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            textAlign = TextAlign.End,
            text = "Total: $formattedProfit USD",
            color = if (isProfit) LocalBtDColorPalette.current.greenCustomColor else LocalBtDColorPalette.current.redUnprofitableColor
        )
    }
}

@Composable
fun OrderRow(
    order: OrderData,
    bgColor: Color,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = bgColor),
        horizontalArrangement = spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val color = if (order.isProfit) LocalBtDColorPalette.current.greenCustomColor else LocalBtDColorPalette.current.redUnprofitableColor

        BtdText(modifier = Modifier.weight(0.8f), text = order.profitCurrency.toString() + " USD", color = color)
        BtdText(modifier = Modifier.weight(0.7f), text = order.profitPercent.toString() + "%", color = color)
        BtdText(modifier = Modifier.weight(1f), text = order.symbol)
        BtdText(modifier = Modifier.weight(1f), text = order.status.name, size = 10.sp)
    }
}

@Composable
@Preview
fun PreviewOrderTableCard() {
    OrderTableCard(
        previewOrderList(),
        isProfit = true,
        profitCurrency = 0.49
    )
}

@Composable
@Preview
fun PreviewUnprofitableOrderTableCard() {
    OrderTableCard(
        previewOrderList(),
        isProfit = false,
        profitCurrency = -0.49
    )
}

private fun previewOrderList() =
    listOf(
        OrderData(
            profitCurrency = 0.49,
            profitPercent = 2.34,
            symbol = "DOGEUSD",
            botName = "STRATEGY 1",
            status = OrderStatus.FILLED,
            orderDate = 423423424233,
            sellDate = 4243243243244,
            isProfit = true
        ),
        OrderData(
            profitCurrency = 0.54,
            profitPercent = 2.64,
            symbol = "BITUSD",
            botName = "STRATEGY 2",
            status = OrderStatus.FILLED,
            orderDate = 4234234242334,
            sellDate = 42432432432442,
            isProfit = true
        ),
        OrderData(
            profitCurrency = -0.49,
            profitPercent = -2.34,
            symbol = "DOGEUSD",
            botName = "STRATEGY 1",
            status = OrderStatus.MARKET_SOLD,
            orderDate = 423423424233,
            sellDate = 4243243243244,
            isProfit = false
        ),
        OrderData(
            profitCurrency = 0.49,
            profitPercent = 2.34,
            symbol = "DOGEUSD",
            botName = "STRATEGY 1",
            status = OrderStatus.FILLED,
            orderDate = 423423424233,
            sellDate = 4243243243244,
            isProfit = true
        ),
        OrderData(
            profitCurrency = -20.0,
            profitPercent = -100.0,
            symbol = "UNIUSD",
            botName = "STRATEGY 1",
            status = OrderStatus.LIMIT_SOLD,
            orderDate = 423423424233,
            sellDate = 4243243243244,
            isProfit = false
        ),
        OrderData(
            profitCurrency = 69.0,
            profitPercent = 69.0,
            symbol = "DOGEUSD",
            botName = "STRATEGY 1",
            status = OrderStatus.FILLED,
            orderDate = 423423424233,
            sellDate = 4243243243244,
            isProfit = true
        ),
    )