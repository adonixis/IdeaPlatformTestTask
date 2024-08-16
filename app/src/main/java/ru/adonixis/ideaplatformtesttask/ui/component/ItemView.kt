package ru.adonixis.ideaplatformtesttask.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.adonixis.ideaplatformtesttask.R
import ru.adonixis.ideaplatformtesttask.domain.model.Item
import ru.adonixis.ideaplatformtesttask.domain.model.toFormattedDate
import ru.adonixis.ideaplatformtesttask.ui.theme.Purple
import ru.adonixis.ideaplatformtesttask.ui.theme.Red
import ru.adonixis.ideaplatformtesttask.ui.theme.White

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ItemView(
    item: Item,
    onEditClicked: () -> Unit,
    onDeleteClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp,
        ),
        shape = MaterialTheme.shapes.extraSmall,
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 6.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 12.dp, start = 10.dp),
                text = item.name,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                ),
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = onEditClicked,
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = Icons.Default.Edit.name,
                    tint = Purple
                )
            }
            IconButton(
                onClick = onDeleteClicked
            ) {
                Icon(
                    imageVector = Icons.Rounded.Delete,
                    contentDescription = Icons.Rounded.Delete.name,
                    tint = Red
                )
            }
        }

        if (item.tags.isNotEmpty()) {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                item.tags.forEach { tag ->
                    CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                        AssistChip(
                            onClick = {},
                            label = { Text(tag) },
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp, start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(100.dp)
        ) {
            Column {
                Text(
                    text = stringResource(R.string.in_stock),
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Medium)
                )
                Text(
                    text = item.amount.toString(),
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Normal)
                )
            }
            Column {
                Text(
                    text = stringResource(R.string.date_added),
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Medium)
                )
                Text(
                    text = item.time.toFormattedDate(),
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Normal)
                )
            }
        }
    }
}
