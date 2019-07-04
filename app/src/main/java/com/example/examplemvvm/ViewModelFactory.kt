package com.example.examplemvvm

import android.annotation.SuppressLint
import android.app.Application
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.examplemvvm.tasks.TasksViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory private constructor(
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T :ViewModel> create(modelClass: Class<T>) =
        with(modelClass){
            when{
                isAssignableFrom(TasksViewModel::class.java) ->
                    TasksViewModel()
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
            INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                INSTANCE ?: ViewModelFactory(
                ).also { INSTANCE = it }
            }

        @VisibleForTesting fun destroyInstance(){
            INSTANCE = null
        }

    }

}
