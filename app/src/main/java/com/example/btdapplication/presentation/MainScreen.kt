package com.example.btdapplication.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btdapplication.composables.BtdText
import com.example.btdapplication.composables.OrderTableCard
import com.example.btdapplication.data.CategoryOrders
import com.example.btdapplication.data.MainViewActions
import com.example.btdapplication.data.OrderData
import com.example.btdapplication.data.OrderStatus
import com.example.btdapplication.themes.LocalBtDColorPalette


@Composable
fun MainScreen(
    uiState: MainScreenUiState,
    handleAction: (MainViewActions) -> Unit = {},
) {
    when (uiState) {
        is MainScreenUiState.Success -> {
            MainScreenContent(
                uiState = uiState,
                handleAction = handleAction,
            )
        }

        is MainScreenUiState.Loading -> {
            LoadingScreen()
        }
    }
}

@Composable
fun MainScreenContent(
    uiState: MainScreenUiState.Success,
    handleAction: (MainViewActions) -> Unit = {},
) {
    TopMenu(
        handleAction = handleAction,
        isProfit = uiState.isGeneralProfitPositive,
        totalProfit = uiState.generalProfitCurrency,
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(LocalBtDColorPalette.current.darkBackgroundColor)
                .padding(paddingValues),
            horizontalAlignment = CenterHorizontally,
            contentPadding = PaddingValues(30.dp),
            verticalArrangement = spacedBy(20.dp)
        ) {
            uiState.orders.forEach { (categoryName, categoryOrder) ->
                item {
                    BtdText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp),
                        textAlign = TextAlign.Start,
                        text = categoryName,
                        size = 20.sp,
                    )
                }
                item {
                    OrderTableCard(
                        orders = categoryOrder.orders,
                        isProfit = categoryOrder.isCategoryProfit,
                        profitCurrency = categoryOrder.categoryProfitCurrency
                    )
                }
            }
        }
//            BottomDrawer(
//                isProfit = uiState.isGeneralProfitPositive,
//                profitCurrency = uiState.generalProfitCurrency,
//            )
    }
}

@Composable
@Preview
fun PreviewLoadingMainScreen() {
    MainScreen(MainScreenUiState.Loading)
}

@Composable
@Preview
fun PreviewMainScreen() {
    MainScreen(
        MainScreenUiState.Success(
            generalProfitCurrency = 0.49,
            isGeneralProfitPositive = true,
            previewMapOfCategory()
        )
    )
}

private fun previewMapOfCategory() = mapOf(
    "Category 1" to CategoryOrders(
        orders = previewOrderList(),
        isCategoryProfit = true,
        categoryProfitCurrency = 0.49
    ),
    "Category 2" to CategoryOrders(
        orders = previewOrderList(),
        isCategoryProfit = false,
        categoryProfitCurrency = -0.49
    ),
    "Category 3" to CategoryOrders(
        orders = previewOrderList(),
        isCategoryProfit = true,
        categoryProfitCurrency = 0.49
    ),
)

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
