package com.good.myweather.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.good.myweather.repository.data.X
import kotlinx.android.synthetic.main.rv_item.view.*

class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvDate = itemView.textview_date
    private val tvDescription = itemView.textview_description

    fun bind(weather: X) {
        tvDate.text = weather.dt.toString()
        tvDescription.text = weather.weather[0].description
    }
}
