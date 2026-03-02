package com.example.btdapplication.domain

import com.example.btdapplication.data.GeneralInfoData

class GetGeneralInfoDataUseCase(
    private val networkRepository: NetworkRepository,
) {

    suspend operator fun invoke(): GeneralInfoData {
        val infoFromNetwork = networkRepository.getAllOrders()

        return GeneralInfoData(
            generalProfitCurrency = infoFromNetwork?.totalPAndL?.toDouble() ?: 0.0,
            generalProfitPercent = infoFromNetwork?.totalPAndLpercent?.toDouble() ?: 0.0,
            isGeneralProfitPositive = (infoFromNetwork?.totalPAndL?.toDouble() ?: 0.0) > 0,
            generalProfitPercentAvg = infoFromNetwork?.totalPAndLpercentAvg?.toDouble() ?: 0.0,
            generalCommission = infoFromNetwork?.commission?.toDouble() ?: 0.0,
        )
    }
}