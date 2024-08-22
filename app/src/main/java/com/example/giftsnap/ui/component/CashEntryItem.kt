package com.example.giftsnap.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.giftsnap.server.entity.CashEntry

@Composable
fun CashEntryItem(cashEntry: CashEntry, onClick: (CashEntry) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick(cashEntry) },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = cashEntry.giverName, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "₹ {cashEntry.amount}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

//@Composable
//fun CashEntryItem(
//    cashEntry: CashEntry,
//    onItemClicked: (CashEntry) -> Unit
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable { onItemClicked(cashEntry) }
//            .padding(16.dp)
//    ) {
//        Text(text = "Amount: \$${cashEntry.amount}")
//        Text(text = "Date: ${cashEntry.date}")
//    }
//}