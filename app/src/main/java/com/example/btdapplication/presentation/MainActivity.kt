package com.example.btdapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.btdapplication.themes.LocalBtDColorPalette
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val systemUiController = rememberSystemUiController()
            val useDarkIcons = false

            CompositionLocalProvider {

                val sideEffectColor = LocalBtDColorPalette.current.darkBackgroundColor

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = sideEffectColor,
                        darkIcons = useDarkIcons
                    )

                    systemUiController.setNavigationBarColor(
                        color = sideEffectColor,
                        darkIcons = useDarkIcons
                    )
                }
                val uiState by viewModel.uiState.collectAsState()

                MainScreen(
                    uiState = uiState,
                    handleAction = { action -> viewModel.handleActions(action) },
                )
            }
        }
    }
}