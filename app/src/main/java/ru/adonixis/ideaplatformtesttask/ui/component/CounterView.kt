package ru.adonixis.ideaplatformtesttask.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material.icons.rounded.RemoveCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.adonixis.ideaplatformtesttask.ui.theme.Purple
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment

@Composable
fun Counter(
    modifier: Modifier,
    initialValue: Int,
    onValueChanged: (Int) -> Unit
) {
    var counter by remember { mutableIntStateOf(initialValue) }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                if (counter > 0) counter--
                onValueChanged(counter)
            }
        ) {
            Icon(
                modifier = Modifier.size(36.dp),
                imageVector = Icons.Rounded.RemoveCircleOutline,
                contentDescription = Icons.Rounded.RemoveCircleOutline.name,
                tint = Purple
            )
        }
        Text(
            text = counter.toString(),
            style = MaterialTheme.typography.titleLarge,
        )
        IconButton(
            onClick = {
                counter++
                onValueChanged(counter)
            }
        ) {
            Icon(
                modifier = Modifier.size(48.dp),
                imageVector = Icons.Rounded.AddCircleOutline,
                contentDescription = Icons.Rounded.AddCircleOutline.name,
                tint = Purple
            )
        }
    }
}
