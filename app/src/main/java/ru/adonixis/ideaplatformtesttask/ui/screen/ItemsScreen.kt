package ru.adonixis.ideaplatformtesttask.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.adonixis.ideaplatformtesttask.R
import ru.adonixis.ideaplatformtesttask.domain.model.Item
import ru.adonixis.ideaplatformtesttask.ui.component.DeleteItemDialog
import ru.adonixis.ideaplatformtesttask.ui.component.EditAmountDialog
import ru.adonixis.ideaplatformtesttask.ui.component.ItemView
import ru.adonixis.ideaplatformtesttask.ui.theme.Gray
import ru.adonixis.ideaplatformtesttask.ui.theme.LightGray
import ru.adonixis.ideaplatformtesttask.ui.theme.White
import ru.adonixis.ideaplatformtesttask.ui.viewmodel.ItemsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsScreen(
    modifier: Modifier = Modifier,
    itemViewModel: ItemsViewModel = hiltViewModel(),
) {
    var query by remember { mutableStateOf("") }
    val allItems by itemViewModel.getAll().collectAsState(listOf())
    val filteredItems = allItems.filter { it.name.contains(query, ignoreCase = true) }
    var currentItem by remember { mutableStateOf<Item?>(null) }
    var currentAmount = currentItem?.amount ?: 0

    var showDeleteDialog by remember { mutableStateOf(false) }
    var showEditAmountDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(vertical = 18.dp),
            text = stringResource(R.string.list_of_products),
            style = MaterialTheme.typography.titleLarge,
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(LightGray),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(10.dp),
        ) {
            item {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = White,
                        unfocusedContainerColor = White,
                        focusedLabelColor = Gray
                    ),
                    textStyle = LocalTextStyle.current.copy(fontSize = 14.sp),
                    value = query,
                    onValueChange = { query = it },
                    label = { Text(stringResource(R.string.search_for_products)) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = Icons.Rounded.Search.name,
                        )
                    },
                    trailingIcon = {
                        if (query.isNotEmpty()) {
                            IconButton(
                                onClick = { query = "" }
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Clear,
                                    contentDescription = Icons.Rounded.Clear.name
                                )
                            }
                        }
                    }
                )
            }

            items(filteredItems) { item ->
                ItemView(
                    item = item,
                    onEditClicked = {
                        currentItem = item
                        showEditAmountDialog = true
                    },
                    onDeleteClicked = {
                        currentItem = item
                        showDeleteDialog = true
                    }
                )
            }
        }
    }

    when {
        showDeleteDialog -> {
            DeleteItemDialog(
                onDismiss = {
                    showDeleteDialog = false
                },
                onConfirm = {
                    currentItem?.let { item ->
                        itemViewModel.delete(item)
                    }
                    showDeleteDialog = false
                }
            )
        }
        showEditAmountDialog -> {
            EditAmountDialog(
                initialValue = currentItem?.amount ?: 0,
                onValueChanged = { counter ->
                    currentAmount = counter
                },
                onDismiss = {
                    showEditAmountDialog = false
                },
                onConfirm = {
                    currentItem?.let { item ->
                        itemViewModel.update(item.copy(amount = currentAmount))
                    }
                    showEditAmountDialog = false
                }
            )
        }
    }
}
