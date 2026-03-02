package com.example.btdapplication.domain

import com.example.btdapplication.data.CategoryOrders
import com.example.btdapplication.data.OrderData
import com.example.btdapplication.data.OrderStatus
import com.example.btdapplication.data.SortKeyEnum

object OrderUtils {

    private const val SOLD = "SOLD"
    private const val FILLED = "STILL FILLED"
    private const val OLDER = "OLDER THAN WEEK"
    private const val NEWER = "THIS WEEK"

    private const val MILLIS = 1000

    fun sortOrdersByCategory(
        category: SortKeyEnum,
        orders: List<OrderData>,
    ): Map<String, CategoryOrders> {
        return when (category) {
            SortKeyEnum.STRATEGY -> {
                orders.groupBy { it.botName }.mapValues { it -> mapToCategoryOrders(it) }
            }

            SortKeyEnum.SYMBOL -> {
                orders.groupBy { it.symbol }.mapValues { it -> mapToCategoryOrders(it) }
            }

            SortKeyEnum.STATUS -> {
                val (filled, sold) = orders.partition { it.status == OrderStatus.FILLED }
                mapOf(FILLED to filled, SOLD to sold).mapValues { it -> mapToCategoryOrders(it) }
            }

            SortKeyEnum.ORDER_DATE -> {
                partitionOlderByOrderTime(orders).mapValues { it -> mapToCategoryOrders(it) }
            }

            SortKeyEnum.SELL_DATE -> {
                partitionOlderBySellTime(orders).mapValues { it -> mapToCategoryOrders(it) }
            }
        }
    }

    private fun partitionOlderByOrderTime(orders: List<OrderData>): Map<String, List<OrderData>> {
        val (older, newer) = orders.partition { it.orderDate * MILLIS < System.currentTimeMillis() - 7 * 24 * 60 * 60 * MILLIS }
        return mapOf(NEWER to newer, OLDER to older)
    }

    private fun partitionOlderBySellTime(orders: List<OrderData>): Map<String, List<OrderData>> {
        val (filled, sold) = orders.partition { it.status == OrderStatus.FILLED }
        val (older, newer) = sold.partition { it.orderDate * MILLIS < System.currentTimeMillis() - 7 * 24 * 60 * 60 * MILLIS }
        return mapOf(NEWER to newer, OLDER to older, FILLED to filled)
    }

    private fun mapToCategoryOrders(mapEntry: Map.Entry<String, List<OrderData>>): CategoryOrders {
        return CategoryOrders(
            isCategoryProfit = mapEntry.value.sumOf { it.profitCurrency } > 0,
            categoryProfitCurrency = mapEntry.value.sumOf { it.profitCurrency },
            orders = mapEntry.value
        )
    }
}