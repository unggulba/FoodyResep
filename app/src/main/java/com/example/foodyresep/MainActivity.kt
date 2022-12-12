package com.example.foodyresep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title = "Resep"
        loadFragment(mainFragment())
        bottomNav = findViewById(R.id.bottomNavigationView) as BottomNavigationView
        bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.recipesFragment -> {
                    loadFragment(mainFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.favoriteRecipesFragment -> {
                    loadFragment(favoriteFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.wheels -> {
                    loadFragment(gamesFragment())
                    return@setOnNavigationItemReselectedListener
                }
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}