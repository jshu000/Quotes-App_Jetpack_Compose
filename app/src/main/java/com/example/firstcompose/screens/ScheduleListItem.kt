package com.example.firstcompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.firstcompose.models_Schedule.ScheduleX
import com.example.firstcompose.models_Team.Team
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ScheduleListItem(
    scheduleX: ScheduleX,
    team1: Team?,
    team2: Team?,
    onClick: (scheduleX: ScheduleX) -> Unit
) {
    val team1 by remember  { mutableStateOf<Team?>(team1) }
    val team2 by remember  { mutableStateOf<Team?>(team2) }
    val scheduleX by remember  { mutableStateOf<ScheduleX>(scheduleX) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${convertGameTime(scheduleX.gametime)} | ${getstatus(scheduleX.st)}",
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                GlideImage(
                    model = team1?.logo,
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(8.dp)
                )
                Text(
                    text = "${scheduleX.h.s}",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "@",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${scheduleX.h.s}",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                GlideImage(
                    model = team2?.logo,
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(8.dp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = scheduleX.h.ta,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(20.dp,0.dp,0.dp,0.dp)
                )
                Text(
                    text = scheduleX.v.ta,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(0.dp,0.dp,20.dp,0.dp)
                )
            }


        }
    }
}
fun convertGameTime(gametime: String): String {
    val formatter = DateTimeFormatter.ofPattern("EEE MMM d | h:mm a")
        .withZone(ZoneId.of("UTC"))  // Adjust the zone as needed

    // Parse the ISO 8601 string to Instant
    val instant = Instant.parse(gametime)

    // Format the instant using the custom pattern
    return formatter.format(instant)
}
fun getstatus(value: Int): String {
    if(value==1){
        return "Future Game"
    }else if(value==2){
        return "Live Game"
    }
    else{
        return "Past Game"
    }
}



