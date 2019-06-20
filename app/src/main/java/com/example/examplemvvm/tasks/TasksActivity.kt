package com.example.examplemvvm.tasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.examplemvvm.R
import com.example.examplemvvm.statistics.StatisticsActivity
import com.google.android.material.navigation.NavigationView

class TasksActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        setupNavigationDrawer()

    }

    private fun setupNavigationDrawer(){
        drawerLayout = (findViewById(R.id.drawer_layout))
        setupDrawerContent(findViewById(R.id.nav_view))
    }

    private fun setupDrawerContent(navigationView : NavigationView){
        navigationView.setNavigationItemSelectedListener() { menuItem ->
            when(menuItem.itemId){
                R.id.list_navigation_menu_item -> { }
                R.id.statistics_navigation_menu_item -> {
                    val intent = Intent(this@TasksActivity, StatisticsActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        startActivity(intent)
                    }
                }
            }
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }

    }

}
