package com.cyoapp.cataloguemovie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cyoapp.cataloguemovie.Model.Movie
import kotlinx.android.synthetic.main.detail.*


class Detail : AppCompatActivity(){
    lateinit var movie : Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail)

        val actionBar = supportActionBar
        actionBar!!.title = "Movie Detail"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

        movie = intent.getParcelableExtra("movie")
        setToView()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun setToView(){
    ivDetailIcon.setImageResource(movie.image)
    tvDetailTitle.text = movie.title
    tvDetailYear.text = movie.year
    tvDetailLanguage.text = movie.language
    tvDetailGenre.text = movie.genre
    tvDetailOverview.text = movie.overview
    }

    }



