package com.example.btdapplication.data

data class CategoryOrders(
    val isCategoryProfit: Boolean,
    val categoryProfitCurrency: Double,
    val orders: List<OrderData>
)