package ru.adonixis.ideaplatformtesttask.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.adonixis.ideaplatformtesttask.ui.theme.Gray
import ru.adonixis.ideaplatformtesttask.R
import ru.adonixis.ideaplatformtesttask.ui.theme.LightGray

@Composable
fun EditAmountDialog(
    initialValue: Int,
    onValueChanged: (Int) -> Unit,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        containerColor = LightGray,
        onDismissRequest = onDismiss,
        icon = {
            Icon(
                imageVector = Icons.Rounded.Settings,
                contentDescription = Icons.Rounded.Settings.name,
                tint = Gray
            )
        },
        title = {
            Text(stringResource(R.string.amount_of_products))
        },
        text = {
            Counter(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 56.dp),
                initialValue = initialValue,
                onValueChanged = onValueChanged
            )
        },
        confirmButton = {
            TextButton(
                onClick = onConfirm,
            ) {
                Text(stringResource(R.string.accept))
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(stringResource(R.string.cancel))
            }
        }
    )
}
