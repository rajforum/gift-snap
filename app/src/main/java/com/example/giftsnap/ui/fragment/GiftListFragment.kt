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
import com.example.giftsnap.ui.viewmodel.GiftViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GiftListFragment : Fragment() {

    private val viewModel: GiftViewModel by viewModels()

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
                        GiftListScreen(viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun GiftListScreen(viewModel: GiftViewModel) {
    val giftEntries by viewModel.gifts.observeAsState(initial = emptyList())

    LazyColumn {
        items(giftEntries.size) { index ->
            Text(text = giftEntries[index].description)
        }
    }
}