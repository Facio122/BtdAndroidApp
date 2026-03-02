package com.example.btdapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.btdapplication.data.CategoryOrders
import com.example.btdapplication.data.MainViewActions
import com.example.btdapplication.data.MainViewActions.SortOrdersByCategory
import com.example.btdapplication.data.OrderData
import com.example.btdapplication.data.SortKeyEnum
import com.example.btdapplication.domain.GetGeneralInfoDataUseCase
import com.example.btdapplication.domain.GetOrdersDataUseCase
import com.example.btdapplication.domain.OrderUtils
import com.example.btdapplication.presentation.MainScreenUiState.Loading
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MainViewModel(
    private val getOrdersDataUseCase: GetOrdersDataUseCase,
    private val getGeneralInfoDataUseCase: GetGeneralInfoDataUseCase,
) : ViewModel() {

    private companion object {
        const val FIVE_MINUTE = 60_000L * 5
    }

    private val _uiState = MutableStateFlow<MainScreenUiState>(Loading)
    val uiState: StateFlow<MainScreenUiState> = _uiState

    private val _orderList = mutableListOf<OrderData>()

    init {
        fetchOrders()
    }

    fun handleActions(action: MainViewActions) {
        when (action) {
            is SortOrdersByCategory -> sortOrdersByCategory(action.category)
        }
    }

    private fun fetchOrders() {
        viewModelScope.launch {
            while (isActive) {

                val orders = getOrdersDataUseCase.invoke()
                val generalInfo = getGeneralInfoDataUseCase.invoke()

                _orderList.clear()
                _orderList.addAll(orders)

                val createMapOfCategoryOrders = createMapOfCategoryOrders(orders)

                _uiState.value = MainScreenUiState.Success(
                    generalProfitCurrency = generalInfo.generalProfitCurrency,
                    isGeneralProfitPositive = generalInfo.isGeneralProfitPositive,
                    orders = createMapOfCategoryOrders
                )
                sortOrdersByCategory(SortKeyEnum.STRATEGY)

                println("Fetching Data")
                delay(FIVE_MINUTE)
            }
        }
    }

    private fun sortOrdersByCategory(category: SortKeyEnum) {
        val sortedOrders = OrderUtils.sortOrdersByCategory(category, _orderList)

        _uiState.update { currentState ->
            when (currentState) {
                is MainScreenUiState.Success -> currentState.copy(orders = sortedOrders)
                else -> currentState
            }
        }
    }

    private fun createMapOfCategoryOrders(orders: List<OrderData>): Map<String, CategoryOrders> {
        val profit = orders.sumOf { it.profitCurrency }
        val isProfitPositive = profit > 0
        return mapOf("" to CategoryOrders(isProfitPositive, profit, orders))
    }
}