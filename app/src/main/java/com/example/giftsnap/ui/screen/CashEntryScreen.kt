package com.example.giftsnap.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import com.example.giftsnap.server.entity.CashEntry
import com.example.giftsnap.ui.component.CashEntryItem

@Composable
fun CashEntryListScreen(
    cashEntries: List<CashEntry>,
    onItemClicked: (CashEntry) -> Unit
) {
    LazyColumn {
        items(cashEntries.size) { index ->
            CashEntryItem(
                cashEntry = cashEntries[index],
                onClick = onItemClicked
            )
        }
    }
}
