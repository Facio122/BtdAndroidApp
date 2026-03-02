package com.example.btdapplication.domain

import com.example.btdapplication.data.ApiService
import com.example.btdapplication.data.BotResponseData
import com.example.btdapplication.data.OrdersResponseData
import com.example.btdapplication.data.PostRequestForOrdersData

class NetworkRepositoryImpl(
    private val apiService: ApiService
) : NetworkRepository {

    private companion object {
        const val BEARER_TOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIvYXBpL2N1c3RvbWVycy9hdXRoL2xvZ2luIiwiaWF0IjoxNzcyNDY0Mjg3LCJleHAiOjE3NzQyNzg2ODcsIm5iZiI6MTc3MjQ2NDI4NywianRpIjoiMWl5SDhSZ2Z5TTNTSVh4RyIsInN1YiI6NDQ5MjQsInBydiI6IjhiNDIyZTZmNjU3OTMyYjhhZWJjYjFiZjFlMzU2ZGQ3NmEzNjViZjIiLCJwbGFuIjoiZnVsbC1hY2Nlc3MiLCJleHBpcmVkX2F0Ijo0MTIyMzA5NjAwfQ.DNfBp9n7wk97Q-ihkaIVb4bZgBi1FtgXBd1kRBlZt24"
    }

    override suspend fun getOrdersFromSpecificBot(botId: Int): OrdersResponseData? {
        val request = PostRequestForOrdersData(id = botId)

        return try {
            apiService.getOrders(request, BEARER_TOKEN)
        } catch (e: Exception) {
            println(e)
            null
        }
    }

    override suspend fun getAllOrders(): OrdersResponseData? {
        val request = PostRequestForOrdersData(all = 1)

        return try {
            apiService.getOrders(request, BEARER_TOKEN)
        } catch (e: Exception) {
            println(e)
            null
        }
    }

    override suspend fun getBots(): BotResponseData? {
        return try {
            apiService.getBots( BEARER_TOKEN)
        } catch (e: Exception) {
            println(e)
            null
        }
    }
}