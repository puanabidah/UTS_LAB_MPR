package com.example.uts_lab_mpr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_lab_mpr.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var movieRecyclerView: RecyclerView
    private lateinit var movieArrayList: ArrayList<Movies>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        setupWithNavController(bottomNavigationView, navController)

        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b
        )

        heading = arrayOf(
            "Black Panther: Wakanda Forever",
            "Enola Holmes 2"
        )

        movieRecyclerView = findViewById(R.id.recyclerViewHome)
        movieRecyclerView.layoutManager = LinearLayoutManager(this)
        movieRecyclerView.setHasFixedSize(true)

        movieArrayList = arrayListOf()
        getUserData()
    }

    private fun getUserData() {
        for (i in imageId.indices) {
            val movies = Movies(imageId[i], heading[i])
            movieArrayList.add(movies)
        }
        movieRecyclerView.adapter = MyAdapter(movieArrayList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu1 -> {
                Toast.makeText(this, "Not Available yet", Toast.LENGTH_SHORT ).show()
                return true
            }
            R.id.menu2 -> {
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return true
        }
    }
}