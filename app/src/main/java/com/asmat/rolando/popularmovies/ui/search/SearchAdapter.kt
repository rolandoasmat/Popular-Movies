package com.asmat.rolando.popularmovies.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.asmat.rolando.popularmovies.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.poster_grid_item.view.*

class SearchAdapter(private val callbacks: Callbacks): RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private var items: List<SearchViewModel.SearchResultUiModel> = emptyList()

    fun setData(items: List<SearchViewModel.SearchResultUiModel>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.poster_grid_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val poster: ImageView? = view.poster
        private val label: TextView? = view.label

        fun bind(data: SearchViewModel.SearchResultUiModel) {
            if (data.imageURL.isNotEmpty()) {
                Picasso.get()
                        .load(data.imageURL)
                        .resize(340, 500)
                        .into(poster)

            }
            label?.text = data.title
        }
    }

    interface Callbacks {
        fun onClick()
    }
}