package com.example.firstcompose

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.firstcompose.models2.Schedule
import com.example.firstcompose.models2.ScheduleX
import com.example.firstcompose.models3.Team
import com.example.firstcompose.models3.Teams
import com.google.gson.Gson
import javax.inject.Inject

class Repository (
    private val context: Context
    /*private val apiService: APIService,
    private val dbService: DBService*/
) {

    fun loadAssetFromFile2() :Array<ScheduleX>{
        val inputStream = context.assets.open("Schedule.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        val data3 = gson.fromJson(json, Schedule::class.java)
        return data3.data.schedules.toTypedArray()
    }

    fun loadAssetFromFile3(): Array<Team> {
        val inputStream = context.assets.open("teams.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        val data3 = gson.fromJson(json, Teams::class.java)
        return data3.data.teams.toTypedArray()

    }
}