package com.example.firstcompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.firstcompose.viewmodels.MainViewModel
import com.example.firstcompose.models_Schedule.ScheduleX
import com.example.firstcompose.models_Team.Team

@Composable
fun ScheduleXList(
    viewModel: MainViewModel,
    onClick: (scheduleX: ScheduleX) -> Unit

){
    val schedules = viewModel.schedules.observeAsState()
    val teams = viewModel.teams.observeAsState()
    var selectedMonth by remember { mutableStateOf("JULY 2023") }
    MonthSelector(
        selectedMonth = selectedMonth,
        onMonthSelected = { selectedMonth = it }
    )
    LazyColumn(content = {
        if (schedules.value!= null){
            items(schedules.value!!){
                if (it != null) {
                    val tid1= it.h.tid
                    val tid2 = it.v.tid
                    val team1: Team? = teams.value?.find { it?.tid == tid1 }
                    val team2: Team? = teams.value?.find { it?.tid == tid2 }
                    ScheduleListItem(scheduleX = it ,team1,team2, onClick)
                }
            }
        }
    })
    //}
}
@Composable
fun MonthSelector(
    selectedMonth: String,
    onMonthSelected: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    val months = listOf( "October 2023", "November 2023", "December 2023","January 2024", "February 2024", "March 2024", "April 2024")

    OutlinedTextField(
        value = selectedMonth,
        onValueChange = {}, // Read-only
        readOnly = true,
        textStyle = TextStyle(color = Color.White),
        trailingIcon = {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = if (expanded) "Collapse" else "Expand",
                    modifier = Modifier.rotate(if (expanded) 180f else 0f)
                )
            }
        },
        modifier = Modifier.
        fillMaxWidth(),


    )
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier.fillMaxWidth(),
    ) {
        months.forEach { month ->
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onMonthSelected(month)
                },
                text = { Text(text = month, style = TextStyle(color = Color.White)) }
            )
        }
    }
}