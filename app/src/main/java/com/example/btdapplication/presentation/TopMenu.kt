package com.example.btdapplication.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btdapplication.R
import com.example.btdapplication.composables.BtdText
import com.example.btdapplication.data.MainViewActions
import com.example.btdapplication.themes.Colors
import com.example.btdapplication.themes.LocalBtDColorPalette

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopMenu(
    handleAction: (MainViewActions) -> Unit = {},
    isProfit: Boolean = true,
    totalProfit: Double = 0.0,
    content: @Composable ((PaddingValues) -> Unit),
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            painter = painterResource(R.drawable.btd_icon),
                            tint = Colors.green,
                            contentDescription = "Btd icon"
                        )
                        Spacer(Modifier.padding(horizontal = 2.dp))
                        TotalProfitText(isProfit, totalProfit)
                    }
                },
                actions = {
                    StatusSortDropdown(
                        onStatusSelected = handleAction
                    )
                    Spacer(Modifier.padding(horizontal = 5.dp))
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Settings, contentDescription = "Search")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = LocalBtDColorPalette.current.darkBackgroundColor,
                    titleContentColor = LocalBtDColorPalette.current.boneTextColor,
                    actionIconContentColor = LocalBtDColorPalette.current.boneTextColor,
                )
            )
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}

@Composable
fun TotalProfitText(isProfitable: Boolean, profit: Double) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BtdText(
            color = if (isProfitable) LocalBtDColorPalette.current.greenProfitableColor else LocalBtDColorPalette.current.redUnprofitableColor,
            text = "Total P&L:"
        )
        BtdText(
            color = if (isProfitable) LocalBtDColorPalette.current.greenProfitableColor else LocalBtDColorPalette.current.redUnprofitableColor,
            text = " $profit USD"
        )
    }

}

@Composable
@Preview
fun TopMenuPreview() {
    TopMenu(
        handleAction = {},
        content = { }
    )
}