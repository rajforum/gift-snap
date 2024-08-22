package com.example.giftsnap.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import com.example.giftsnap.server.entity.Gift
import com.example.giftsnap.ui.component.GiftItem

@Composable
fun GiftListScreen(
    giftEntries: List<Gift>,
    onItemClicked: (Gift) -> Unit
) {
    LazyColumn {
        items(giftEntries.size) { index ->
            GiftItem(
                gift = giftEntries[index],
                onClick = onItemClicked
            )
        }
    }
}