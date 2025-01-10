package com.example.firstcompose.repository

import android.content.Context
import com.example.firstcompose.models_Schedule.Schedule
import com.example.firstcompose.models_Schedule.ScheduleX
import com.example.firstcompose.models_Team.Team
import com.example.firstcompose.models_Team.Teams
import com.google.gson.Gson

class Repository (
    private val context: Context
) {

    fun loadAssetFromFile2() :Array<ScheduleX>{
        val inputStream = context.assets.open("Schedule.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        val schedules = gson.fromJson(json, Schedule::class.java)
        return schedules.data.schedules.toTypedArray()
    }

    fun loadAssetFromFile3(): Array<Team> {
        val inputStream = context.assets.open("teams.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        val teams = gson.fromJson(json, Teams::class.java)
        return teams.data.teams.toTypedArray()

    }
}