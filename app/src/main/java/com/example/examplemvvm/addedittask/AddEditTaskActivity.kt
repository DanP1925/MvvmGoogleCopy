package com.example.examplemvvm.addedittask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examplemvvm.R
import com.example.examplemvvm.util.setupActionBar

class AddEditTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_task)

        setupActionBar(R.id.toolbar){
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

    }

    companion object {
        const val REQUEST_CODE = 1
    }

}
