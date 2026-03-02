package com.example.btdapplication.domain

import com.example.btdapplication.data.BotResponseData
import com.example.btdapplication.data.OrdersResponseData

interface NetworkRepository {

    suspend fun getOrdersFromSpecificBot(botId: Int): OrdersResponseData?
    suspend fun getAllOrders(): OrdersResponseData?
    suspend fun getBots(): BotResponseData?
}