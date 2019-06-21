package com.example.examplemvvm.statistics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.examplemvvm.R
import com.example.examplemvvm.util.replaceFragmentInActivity

class StatisticsActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)
        findOrCreateViewFragment()
    }

    private fun findOrCreateViewFragment() =
            supportFragmentManager.findFragmentById(R.id.contentFrame)
                    ?: StatisticsFragment.newInstance().also {
                        replaceFragmentInActivity(it, R.id.contentFrame)
                    }

}
