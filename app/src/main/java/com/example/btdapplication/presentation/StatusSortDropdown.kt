package com.example.btdapplication.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.common.composables.BtdButton
import com.common.composables.BtdText
import com.common.themes.Colors.asphalt25
import com.common.themes.Colors.asphalt50
import com.common.themes.LocalBtDColorPalette
import com.example.btdapplication.data.MainViewActions
import com.example.btdapplication.data.SortKeyEnum

@Composable
fun StatusSortDropdown(
    onStatusSelected: (MainViewActions) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedStatus by remember { mutableStateOf(SortKeyEnum.STRATEGY) }

    Row(
        modifier = Modifier
            .height(40.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(asphalt25),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BtdText(
            modifier = Modifier.padding(horizontal = 6.dp),
            text = "sort by"
        )
        Column {
            BtdButton(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .width(100.dp),
                colors = ButtonColors(
                    containerColor = asphalt50,
                    contentColor = LocalBtDColorPalette.current.darkBackgroundColor,
                    disabledContainerColor = LocalBtDColorPalette.current.darkOrderBackgroundColor,
                    disabledContentColor = LocalBtDColorPalette.current.darkBackgroundColor,
                ),
                onClick = { expanded = !expanded }
            ) {
                BtdText(
                    text = selectedStatus.value,
                    size = 12.sp
                )
            }
            DropdownMenu(
                modifier = Modifier
                    .width(100.dp)
                    .background(asphalt25)
                    .clip(RoundedCornerShape(5.dp)),
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                SortKeyEnum.entries.forEachIndexed { index, option ->
                    val isPair = index % 2 == 0

                    DropdownMenuItem(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(if (isPair) asphalt25 else asphalt50),
                        text = { BtdText(option.value) },
                        onClick = {
                            selectedStatus = option
                            onStatusSelected(MainViewActions.SortOrdersByCategory(option))
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun StatusSortDropdownPreview() {
    StatusSortDropdown(
        onStatusSelected = {}
    )
}