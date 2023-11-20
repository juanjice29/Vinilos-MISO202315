package com.miso2023equipo2.vinilos.pages.collector

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.data.model.Collector
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import com.miso2023equipo2.vinilos.ui.components.DataFetchStates
import com.miso2023equipo2.vinilos.ui.components.EmptyItemsScreen
import com.miso2023equipo2.vinilos.ui.components.ListItem
import com.miso2023equipo2.vinilos.ui.components.VinylsList

@Composable
fun CollectorCataloguePage(
    uiState: DataUiState<List<Collector>>,
    onDetailButton: (id: String) -> Unit
) {
    Column(modifier = Modifier) {
        Spacer(modifier = Modifier.height(16.dp))
        DataFetchStates(
            uiState = uiState,
            errorMessage = R.string.loading_failed_albums
        ) {
            if (uiState !is DataUiState.Success) return@DataFetchStates

            if (uiState.data.isEmpty()) {
                EmptyItemsScreen(message = R.string.collectors_not_found)
                return@DataFetchStates
            }

            val listItem: MutableList<ListItem> = mutableListOf()
            uiState.data.forEach { collector ->
                val listGen =
                    ListItem(text = collector.name, imageUrl = collector.name, id = "${collector.id}")
                listItem.add(listGen)

            }
            VinylsList(listItems = listItem, onClickItem = onDetailButton)
        }
    }
}
