package com.example.firstcompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.firstcompose.models.Quote
import com.example.firstcompose.models2.Schedule
import com.example.firstcompose.models2.ScheduleX
import com.example.firstcompose.models3.Team
import com.example.firstcompose.models3.Teams
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Quote?>()
    var currentQuote : Quote? = null
    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)

    var data2 = emptyArray<ScheduleX?>()
    var currentQuote2 : ScheduleX? = null
    var currentPage2 = mutableStateOf(Pages.LISTING)
    var data5= emptyArray<Team?>()
    var isDataLoaded2 = mutableStateOf(false)


    fun loadAssetFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote?>::class.java)
        isDataLoaded.value = true
    }
    fun loadAssetFromFile2(context: Context) {
        val inputStream = context.assets.open("Schedule.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        val data3 = gson.fromJson(json, Schedule::class.java)
        data2= data3.data.schedules.toTypedArray()
        loadAssetFromFile3(context)
        isDataLoaded2.value = true
    }

    private fun loadAssetFromFile3(context: Context) {
        val inputStream = context.assets.open("teams.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        val data3 = gson.fromJson(json, Teams::class.java)
        data5= data3.data.teams.toTypedArray()
        isDataLoaded2.value = true
    }

    fun switchPages(quote: Quote?){
        if(currentPage.value == Pages.LISTING){
            currentQuote= quote
            currentPage.value = Pages.DETAIL
        }else{
            currentPage.value = Pages.LISTING
        }
    }

    fun switchPages2(scheduleX: ScheduleX?){
        if(currentPage.value == Pages.LISTING){
            currentQuote2= scheduleX
            currentPage.value = Pages.DETAIL
        }else{
            currentPage.value = Pages.LISTING
        }
    }
}