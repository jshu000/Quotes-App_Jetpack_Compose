package com.example.firstcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.firstcompose.models2.ScheduleX
import com.example.firstcompose.models3.Team


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ScheduleListItem(
    scheduleX: ScheduleX,
    team1: Team?,
    team2: Team?,
    onClick: (scheduleX: ScheduleX) -> Unit
) {
    Card(elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .clickable { onClick(scheduleX) }
            .padding(8.dp)) {
        Row(modifier = Modifier.padding(16.dp)) {
            GlideImage(
                model = team1?.logo,
                contentDescription = "Image2",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Black)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Home-${scheduleX.h.ta} vs Away-${scheduleX.v.ta}"?:"Text",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(0.dp,0.dp,0.dp,0.dp)
                )
                Text(text = "Home-${scheduleX.h.s} vs Away-${scheduleX.v.s}"?:"Text",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(0.dp,0.dp,0.dp,0.dp)
                )
                Text(text = "Game Status-${scheduleX.st} vs Away-${scheduleX.v.s}"?:"Text",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(0.dp,0.dp,0.dp,0.dp)
                )
                Box(modifier = Modifier
                    .background(Color(0xFFEEEEEE))
                    .fillMaxWidth(.4f)
                    .height(1.dp))
                Text(text = scheduleX.gametime ?:"Author",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top=4.dp))
                Text(text = scheduleX.arena_name ?:"Author",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top=4.dp))
                Text(text = "stt-${scheduleX.stt} "?:"Author",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top=4.dp))


            }
            GlideImage(
                model = team2?.logo,
                contentDescription = "Image2",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Black)
            )
        }
    }

}


