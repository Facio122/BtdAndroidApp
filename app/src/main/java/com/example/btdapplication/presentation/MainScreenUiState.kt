package com.example.btdapplication.presentation

import com.example.btdapplication.data.CategoryOrders

sealed interface MainScreenUiState {

    object Loading : MainScreenUiState

    data class Success(
        val generalProfitCurrency: Double,
        val isGeneralProfitPositive: Boolean,
        val orders: Map<String, CategoryOrders>
    ) : MainScreenUiState
}