package com.polish.androiduicomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var mToolbar:androidx.appcompat.widget.Toolbar
    private lateinit var mNavigationView:NavigationView
    private lateinit var mDrawer:DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // setup the toolbar
        mToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)

        // initialize the navcontroller
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        // setup the navigation view; this enable the switching amogst the menu
        mNavigationView = findViewById(R.id.navigation_view)
        NavigationUI.setupWithNavController(mNavigationView, navController)
        // display the selected title to the navigation toolbar
        mDrawer = findViewById(R.id.drawer_layout)
        NavigationUI.setupActionBarWithNavController(this, navController, mDrawer)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            navController,
            mDrawer
        )
    }
}