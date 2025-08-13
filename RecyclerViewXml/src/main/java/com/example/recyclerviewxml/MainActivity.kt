package com.example.recyclerviewxml

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val movieList = listOf(
        Movie("The Shawshank Redemption", "Drama", 1994, 9.3),
        Movie("The Godfather", "Crime", 1972, 9.2),
        Movie("The Dark Knight", "Action", 2008, 9.0),
        Movie("Pulp Fiction", "Crime", 1994, 8.9),
        Movie("Inception", "Sci-Fi", 2010, 8.8),
        Movie("Fight Club", "Drama", 1999, 8.8),
        Movie("Forrest Gump", "Drama", 1994, 8.8),
        Movie("The Matrix", "Sci-Fi", 1999, 8.7),
        Movie("Interstellar", "Sci-Fi", 2014, 8.6),
        Movie("The Green Mile", "Drama", 1999, 8.6)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        Prefs.applySavedTheme(this) // tema din Settings (ON/OFF)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rv = findViewById<RecyclerView>(R.id.rvMovies)
        val lm = LinearLayoutManager(this)
        rv.layoutManager = lm
        rv.addItemDecoration(DividerItemDecoration(this, lm.orientation))
        rv.adapter = MovieAdapter(movieList) { movie ->
            Toast.makeText(this, movie.title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
