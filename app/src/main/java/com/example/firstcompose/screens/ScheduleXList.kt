package com.example.firstcompose.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.firstcompose.models2.ScheduleX
import com.example.firstcompose.models3.Team

@Composable
fun ScheduleXList(
    data: Array<ScheduleX?>,
    data5: Array<Team?>,
    onClick: (scheduleX: ScheduleX) -> Unit
){
    /*Column(modifier = Modifier.fillMaxHeight(1f).fillMaxHeight()) {
        Text(
            text = "Quote App",
            modifier = Modifier.fillMaxWidth(1f),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.padding(4.dp))*/
    LazyColumn(content = {
        items(data){
            if (it != null) {
                val tid1= it.h.tid
                val tid2 = it.v.tid
                val team1: Team? = data5.find { it?.tid == tid1 }
                val team2: Team? = data5.find { it?.tid == tid2 }
                ScheduleListItem(scheduleX = it ,team1,team2, onClick)
            }
        }
    })
    //}
}