package com.example.examplemvvm.statistics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.examplemvvm.R
import com.example.examplemvvm.util.replaceFragmentInActivity
import com.example.examplemvvm.util.setupActionBar

class StatisticsActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        setupActionBar(R.id.toolbar){
            setTitle(R.string.statistics_title)
        }

        findOrCreateViewFragment()
    }

    private fun findOrCreateViewFragment() =
            supportFragmentManager.findFragmentById(R.id.contentFrame)
                    ?: StatisticsFragment.newInstance().also {
                        replaceFragmentInActivity(it, R.id.contentFrame)
                    }

}
