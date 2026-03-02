package com.example.btdapplication.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btdapplication.R
import com.example.btdapplication.composables.BtdText
import com.example.btdapplication.composables.BtdTextField
import com.example.btdapplication.themes.LocalBtDColorPalette

@Composable
fun LogInScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LocalBtDColorPalette.current.darkBackgroundColor)
    ) {

        Column(
            modifier = Modifier
                .padding(32.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                modifier = Modifier
                    .weight(0.6f)
                    .size(200.dp),
                painter = painterResource(id = R.drawable.btd_icon),
                tint = LocalBtDColorPalette.current.primary,
                contentDescription = "Btd icon"
            )
            Spacer(modifier = Modifier.height(32.dp))
            BtdText(text = "Welcome in the Buy the Dip max data application", size = 24.sp)
            Spacer(modifier = Modifier.height(32.dp))

            Column(modifier = Modifier.weight(1f)) {
                Spacer(modifier = Modifier.height(32.dp))
                TextField(
                    topLabelText = "E-mail",
                    label = "email",
                    placeholder = "pass your email"
                )
                Spacer(modifier = Modifier.height(48.dp))
                TextField(
                    topLabelText = "Password",
                    label = "password",
                    placeholder = "pass your password"
                )
            }
        }
    }
}

@Composable
fun TextField(topLabelText: String = "", label: String = "", placeholder: String = "") {
    Column {
        BtdText(topLabelText, modifier = Modifier.padding(bottom = 8.dp))
        BtdTextField(
            label = label,
            placeholder = placeholder,
        )
    }
}

@Composable
@Preview
fun LogInScreenPreview() {
    LogInScreen()
}