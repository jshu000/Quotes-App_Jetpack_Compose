package com.example.firstcompose

import android.app.Application
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstcompose.DataManager.data2
import com.example.firstcompose.DataManager.data5
import com.example.firstcompose.DataManager.isDataLoaded2
import com.example.firstcompose.models2.Schedule
import com.example.firstcompose.models2.ScheduleX
import com.example.firstcompose.models3.Team
import com.example.firstcompose.models3.Teams
import com.google.gson.Gson

class MainViewModel(application: Application):ViewModel() {

    private val itemRepository = Repository(application)

    private val _schedules = MutableLiveData<Array<ScheduleX>>()
    val schedules: LiveData<Array<ScheduleX>> get() = _schedules

    private val _teams = MutableLiveData<Array<Team>>()
    val teams: LiveData<Array<Team>> get() = _teams

    fun loadItems() {
        _schedules.value = itemRepository.loadAssetFromFile2()
        _teams.value = itemRepository.loadAssetFromFile3()

    }
}
