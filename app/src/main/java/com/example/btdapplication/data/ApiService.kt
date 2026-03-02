package com.example.btdapplication.data

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("get-orders")
    suspend fun getOrders(
        @Body request: PostRequestForOrdersData,
        @Header("Authorization") token: String,
    ) : OrdersResponseData

    @POST("get-bots")
    suspend fun getBots(
        @Header("Authorization") token: String,
    ) : BotResponseData
}