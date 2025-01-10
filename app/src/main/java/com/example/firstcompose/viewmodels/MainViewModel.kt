package com.example.firstcompose.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.firstcompose.repository.Repository
import com.example.firstcompose.models_Schedule.ScheduleX
import com.example.firstcompose.models_Team.Team

class MainViewModel(application: Application):AndroidViewModel(application) {

    private val itemRepository = Repository(application)

    private val _schedules = MutableLiveData<Array<ScheduleX>>()
    val schedules: LiveData<Array<ScheduleX>> get() = _schedules

    private val _teams = MutableLiveData<Array<Team>>()
    val teams: LiveData<Array<Team>> get() = _teams
    init {
        loadItems()
    }

    fun loadItems() {
        _schedules.value = itemRepository.loadAssetFromFile2()
        _teams.value = itemRepository.loadAssetFromFile3()
        Log.d("jashwantcompose", "loadItems: schedules $_schedules")
        Log.d("jashwantcompose", "loadItems: teams $_teams")

    }
}
