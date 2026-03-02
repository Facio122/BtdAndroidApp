package com.example.btdapplication.domain

import com.example.btdapplication.data.OrderData
import com.example.btdapplication.data.OrderStatus

class GetOrdersDataUseCase(
    private val networkRepository: NetworkRepository,
) {

    private companion object {
        const val MARKET_SOLD = "MARKET SOLD"
        const val LIMIT_SOLD = "LIMIT SOLD"
    }

    suspend fun invoke(botId: Int = 0): List<OrderData> {
        val orders = if (botId == 0) networkRepository.getAllOrders()
        else networkRepository.getOrdersFromSpecificBot(botId)

        return orders?.orders?.map { order ->
            OrderData(
                profitCurrency = order.pAndL?.toDoubleOrNull() ?: 0.0,
                profitPercent = order.profit?.toDoubleOrNull() ?: 0.0,
                symbol = order.symbol,
                botName = getBotName(order.botId),
                status = mapStatusFromOrder(order.status),
                orderDate = order.orderDate,
                sellDate = order.sellDate.toLongOrNull() ?: 0L,
                isProfit = (order.pAndL?.toDoubleOrNull() ?: 0.0) > 0,
            )
        } ?: emptyList()
    }

    private suspend fun getBotName(botId: Int): String {
        val bots = networkRepository.getBots()?.bots

        return bots?.find { it.id == botId }?.name ?: ""
    }

    private fun mapStatusFromOrder(status: String): OrderStatus {
        return when (status) {
            LIMIT_SOLD -> OrderStatus.LIMIT_SOLD
            MARKET_SOLD -> OrderStatus.MARKET_SOLD
            else -> OrderStatus.FILLED
        }
    }
}