package ru.adonixis.ideaplatformtesttask.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.adonixis.ideaplatformtesttask.R
import ru.adonixis.ideaplatformtesttask.ui.theme.Gray
import ru.adonixis.ideaplatformtesttask.ui.theme.LightGray

@Composable
fun DeleteItemDialog(
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
                imageVector = Icons.Rounded.Warning,
                contentDescription = Icons.Rounded.Warning.name,
                tint = Gray
            )
        },
        title = {
            Text(stringResource(R.string.removing_product))
        },
        text = {
            Text(stringResource(R.string.are_you_sure_to_delete))
        },
        confirmButton = {
            TextButton(
                onClick = onConfirm,
            ) {
                Text(stringResource(R.string.yes))
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(stringResource(R.string.no))
            }
        }
    )
}
