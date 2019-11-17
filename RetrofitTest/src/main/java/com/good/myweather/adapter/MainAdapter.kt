package com.good.myweather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.good.myweather.R
import com.good.myweather.data.X

class MainAdapter : RecyclerView.Adapter<WeatherViewHolder>() {
    private var weatherList = mutableListOf<X>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder =
        WeatherViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = weatherList.size

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    fun setData(setDataList: List<X>) {
        this.weatherList.clear()
        this.weatherList.addAll(setDataList)
        notifyDataSetChanged()
    }

}