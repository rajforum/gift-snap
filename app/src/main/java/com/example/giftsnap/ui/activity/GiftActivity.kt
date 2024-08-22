package com.example.giftsnap.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.giftsnap.ui.theme.GiftSnapTheme
import com.example.giftsnap.ui.viewmodel.GiftViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GiftEntryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GiftSnapTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GiftEntryScreen()
                }
            }
        }
    }
}

@Composable
fun GiftEntryScreen(viewModel: GiftViewModel = hiltViewModel()) {
    val giftEntries by viewModel.gifts.observeAsState(emptyList())

    LazyColumn {
        items(giftEntries.size) { index ->
            Text(text = giftEntries[index].description)
        }
    }
}