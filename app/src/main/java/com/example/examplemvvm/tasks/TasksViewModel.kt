package com.example.examplemvvm.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examplemvvm.Event

class TasksViewModel : ViewModel(){

    private val _newTaskEvent = MutableLiveData<Event<Unit>>()
    val newTaskEvent : LiveData<Event<Unit>>
        get() = _newTaskEvent

    fun addNewTask(){
        _newTaskEvent.value = Event(Unit)
    }

}