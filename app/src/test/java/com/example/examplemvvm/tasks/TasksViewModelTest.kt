package com.example.examplemvvm.tasks

import android.app.Application
import android.content.Context
import android.content.res.Resources
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.examplemvvm.LiveDataTestUtil
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class TasksViewModelTest {

    @get:Rule var instantExecutorRule = InstantTaskExecutorRule()
    @Mock private lateinit var context: Application
    private lateinit var tasksViewModel: TasksViewModel

    @Before
    fun setupTasksViewModel(){
        MockitoAnnotations.initMocks(this)

        setupContext()

        tasksViewModel = TasksViewModel()

    }

    private fun setupContext(){
        `when`<Context>(context.applicationContext).thenReturn(context)
        `when`(context.resources).thenReturn(mock(Resources::class.java))
    }

    @Test
    @Throws(InterruptedException::class)
    fun clickOnFab_ShowsAddTaskUi(){
        tasksViewModel.addNewTask()

        val value = LiveDataTestUtil.getValue(tasksViewModel.newTaskEvent)
        assertNotNull(value.getContentIfNotHandled())
    }

}