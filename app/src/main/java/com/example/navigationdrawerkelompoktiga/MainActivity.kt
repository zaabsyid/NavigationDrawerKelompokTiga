package com.example.navigationdrawerkelompoktiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var drawerLayoutTele: DrawerLayout = findViewById(R.id.drawerLayoutTelegram)

        // drawer layout instance to toggle the menu icon to open drawer and back button to close drawer
        var actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayoutTele, R.string.nav_open, R.string.nav_close)

        // pass the Open and Close toggle for the drawer layout listener to toggle the button
        drawerLayoutTele.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // override the onOptionsItemSelected() function to implement the item click listener callback to open and close the navigation drawer when the icon is clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var drawerLayoutTele:DrawerLayout = findViewById(R.id.drawerLayoutTelegram)
        var actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayoutTele, R.string.nav_open, R.string.nav_close)

        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            nav_drawer.setNavigationItemSelectedListener{
                when(it.itemId){
                    R.id.chat -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fcTelegram, ChatFragment())
                            .commit()
                        return@setNavigationItemSelectedListener true
                    }
                    R.id.contact -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fcTelegram, ConractsFragment())
                            .commit()
                        return@setNavigationItemSelectedListener true
                    }
                    R.id.setting -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fcTelegram, SettingsFragment())
                            .commit()
                        return@setNavigationItemSelectedListener true
                    }
                    else -> return@setNavigationItemSelectedListener true
                }
            }
            return true
        }
        else return super.onOptionsItemSelected(item)
    }
}