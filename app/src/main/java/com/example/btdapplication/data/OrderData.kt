package com.example.btdapplication.data

data class OrderData(
    val profitCurrency: Double,
    val profitPercent: Double,
    val symbol: String,
    val botName: String,
    val status: OrderStatus,
    val orderDate: Long,
    val sellDate: Long,
    val isProfit: Boolean,
)