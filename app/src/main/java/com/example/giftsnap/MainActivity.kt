package com.example.giftsnap

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.giftsnap.ui.screen.CashEntryListScreen
import com.example.giftsnap.ui.screen.GiftListScreen
import com.example.giftsnap.ui.theme.GiftSnapTheme
import com.example.giftsnap.ui.viewmodel.CashEntryViewModel
import com.example.giftsnap.ui.viewmodel.GiftViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GiftSnapTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Surface(color = MaterialTheme.colorScheme.background) {
        NavHost(navController = navController, startDestination = "cash_entries") {
            composable("cash_entries") {
                val viewModel: CashEntryViewModel = hiltViewModel()
                val cashEntries = viewModel.cashEntries.observeAsState(initial = emptyList())

                CashEntryListScreen(
                    cashEntries = cashEntries.value,
                    onItemClicked = { /* Handle item click */ }
                )
            }

            composable("gift_entries") {
                val viewModel: GiftViewModel = hiltViewModel()
                val giftEntries = viewModel.gifts.observeAsState(initial = emptyList())

                GiftListScreen(
                    giftEntries = giftEntries.value,
                    onItemClicked = { /* Handle item click */ }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GiftSnapTheme {
        MainScreen()
    }
}
