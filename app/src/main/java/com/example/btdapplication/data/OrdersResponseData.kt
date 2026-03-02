package com.example.btdapplication.data

import com.google.gson.annotations.SerializedName

data class OrdersResponseData(
    @SerializedName("error") val error: String?,
    @SerializedName("msg") val msg: String,
    @SerializedName("count") val count: Int,
    @SerializedName("orders") val orders: List<Order>,
    @SerializedName("totalPAndL") val totalPAndL: String?,
    @SerializedName("totalPAndLpercent") val totalPAndLpercent: String?,
    @SerializedName("totalPAndLpercent_avg") val totalPAndLpercentAvg: String?,
    @SerializedName("commission") val commission: String?
)

data class Order(
    @SerializedName("pAndL") val pAndL: String?,
    @SerializedName("profit") val profit: String?,
    @SerializedName("bot_id") val botId: Int,
    @SerializedName("uid") val uid: Int,
    @SerializedName("orderID") val orderId: String,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("executedQty") val executedQty: Double,
    @SerializedName("price") val price: Double,
    @SerializedName("status") val status: String,
    @SerializedName("sold") val sold: Int,
    @SerializedName("orderDate") val orderDate: Long,
    @SerializedName("sellPrice") val sellPrice: String,
    @SerializedName("sellDate") val sellDate: String,
)
