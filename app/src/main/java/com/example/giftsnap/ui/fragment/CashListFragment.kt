package com.example.giftsnap.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import com.example.giftsnap.ui.theme.GiftSnapTheme
import com.example.giftsnap.ui.viewmodel.CashEntryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CashListFragment : Fragment() {

    private val viewModel: CashEntryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                GiftSnapTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        CashListScreen(viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun CashListScreen(viewModel: CashEntryViewModel) {
    val cashEntries by viewModel.cashEntries.observeAsState(initial = emptyList())
//    Scaffold(
//        topBar = {
//            TopAppBar(title = { Text("Cash Entries") })
//        }
//    ) { paddingValues ->
//        Column(modifier = Modifier.fillMaxSize()) {
//            cashEntries.forEach { entry ->
//                // Display each cash entry
//                Text(text = "${entry.description}: ${entry.amount}")
//            }
//        }
//    }
    LazyColumn {
        items(cashEntries.size) { index ->
            Text(text = cashEntries[index].giverName)
        }
    }
}