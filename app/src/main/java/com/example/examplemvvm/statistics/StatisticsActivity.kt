package com.example.examplemvvm.statistics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.examplemvvm.R
import com.example.examplemvvm.tasks.TasksActivity
import com.example.examplemvvm.util.replaceFragmentInActivity
import com.example.examplemvvm.util.setupActionBar
import com.google.android.material.navigation.NavigationView

class StatisticsActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        setupActionBar(R.id.toolbar) {
            setTitle(R.string.statistics_title)
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayHomeAsUpEnabled(true)
        }

        setupNavigationDrawer()

        findOrCreateViewFragment()
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when(item.itemId){
            android.R.id.home ->{
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    private fun findOrCreateViewFragment() =
            supportFragmentManager.findFragmentById(R.id.contentFrame)
                    ?: StatisticsFragment.newInstance().also {
                        replaceFragmentInActivity(it, R.id.contentFrame)
                    }

    private fun setupNavigationDrawer(){
        drawerLayout = (findViewById<DrawerLayout>(R.id.drawer_layout)).apply {
            setStatusBarBackground(R.color.colorPrimaryDark)
        }
        setupDrawerContent(findViewById(R.id.nav_view))
    }

    private fun setupDrawerContent(navigationView: NavigationView){
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.list_navigation_menu_item -> {
                    val intent = Intent(this@StatisticsActivity, TasksActivity::class.java)
                    startActivity(intent)
                }
                R.id.statistics_navigation_menu_item -> {}
            }
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }

}
