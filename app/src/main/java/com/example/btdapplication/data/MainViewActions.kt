package com.example.btdapplication.data

sealed class MainViewActions {

    data class SortOrdersByCategory(val category: SortKeyEnum): MainViewActions()
}