package com.cyoapp.cataloguemovie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.cyoapp.cataloguemovie.Model.Movie

class MovieAdapter(private val context: Context, private val movies: ArrayList<Movie>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val convertView = inflater.inflate(R.layout.item, parent, false)

        var viewHolder = ViewHolder(convertView)
        var movie = getItem(position)
        viewHolder.bind(movie as Movie)

        return convertView
    }

    override fun getItem(position: Int): Any {
        return this.movies.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return this.movies.size
    }

    private class ViewHolder(view: View) {
        private var txtTitle: TextView = view.findViewById(R.id.tvDetailTitle)
        private var txtGenre: TextView = view.findViewById(R.id.tvDetailGenre)
        private var txtLang: TextView = view.findViewById(R.id.tvDetailLanguage)
        private var ivIcon: ImageView = view.findViewById(R.id.ivDetailIcon)

        fun bind(movie: Movie) {
            txtTitle.text = movie.title
            txtGenre.text = movie.genre
            txtLang.text = movie.language
            ivIcon.setImageResource(movie.image)
        }
    }

}