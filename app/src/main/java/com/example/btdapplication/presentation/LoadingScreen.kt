package com.example.btdapplication.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.btdapplication.R
import com.example.btdapplication.themes.Colors
import com.example.btdapplication.themes.LocalBtDColorPalette

@Composable
fun LoadingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalBtDColorPalette.current.darkBackgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .size(150.dp),
            painter = painterResource(id = R.drawable.btd_icon),
            contentDescription = "Btd Icon",
            tint = LocalBtDColorPalette.current.primary,
        )
        Spacer(modifier = Modifier.padding(30.dp))
        CircularProgressIndicator(
            modifier = Modifier
                .size(75.dp),
            color = Colors.bone,
            strokeWidth = 15.dp
        )
    }
}

@Composable
@Preview
fun PreviewLoadingScreen() {
    LoadingScreen()
}