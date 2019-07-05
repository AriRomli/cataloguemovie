package com.cyoapp.cataloguemovie

import android.content.Intent
import android.content.res.TypedArray
import android.net.VpnService.prepare
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cyoapp.cataloguemovie.Model.Movie
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var titles: Array<String>
    private lateinit var genres: Array<String>
    private lateinit var langs: Array<String>
    private lateinit var years: Array<String>
    private lateinit var overviews: Array<String>
    private lateinit var icons: TypedArray

    private lateinit var adapter: MovieAdapter
    private lateinit var movies: ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepare()
        addItem()

        adapter = MovieAdapter(this, movies)
        lvMovies.adapter = adapter

        lvMovies.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, Detail::class.java)
            intent.putExtra("movie", movies.get(position))
            startActivity(intent)
        }

    }

    private fun addItem() {
        movies = ArrayList()
        for (i in 0 until titles.size) {
            val movie = Movie(
                titles.get(i),
                genres.get(i),
                langs.get(i),
                years.get(i),
                overviews.get(i),
                icons.getResourceId(i, -1))
                movies.add(movie)


        }
    }

    private fun prepare() {
        titles = resources.getStringArray(R.array.data_title)
        genres = resources.getStringArray(R.array.data_genre)
        langs = resources.getStringArray(R.array.data_language)
        years = resources.getStringArray(R.array.data_year)
        overviews = resources.getStringArray(R.array.data_overview)
        icons = resources.obtainTypedArray(R.array.data_image)
    }
}
