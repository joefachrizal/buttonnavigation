package com.android.cnd.buttonnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.android.cnd.buttonnavigation.fragment.MovieFragment
import com.android.cnd.buttonnavigation.fragment.TvShowFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(navSelectedListener)

        if (savedInstanceState == null) {
            navigation.selectedItemId = R.id.navigation_movie
        }
    }

    private val navSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        val fragment: Fragment
        when (it.itemId) {
            R.id.navigation_movie -> {
                fragment = MovieFragment()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_tvshow -> {
                fragment = TvShowFragment()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_layout, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}
