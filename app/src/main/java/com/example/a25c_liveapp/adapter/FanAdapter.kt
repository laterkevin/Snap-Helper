package com.example.a25c_liveapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.a25c_liveapp.R
import com.example.a25c_liveapp.data.model.Fan
import com.example.a25c_liveapp.databinding.FanLayoutBinding

// diesmal benötigt der Adapter den Context um auf die ColorResources zuzugreifen
class FanAdapter(
    private val context: Context,
    private val dataset: List<Fan>
) : RecyclerView.Adapter<FanAdapter.ItemViewHolder>() {

    // der ViewHolder kann über die DatabBinding Variable auf alle Layoutelemente zugreifen
    class ItemViewHolder(val binding: FanLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding = FanLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(binding)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // der aktuelle Fan wird von der Liste geladen
        val item = dataset[position]

        holder.binding.fanImage.setImageResource(item.imageResource)
        holder.binding.fanNameText.text = item.name
        holder.binding.fanPriceText.text = "€${item.price}"

        if (item.sale) {
            holder.binding.fanSaleText.visibility = View.VISIBLE
            holder.binding.fanPriceText.setTextColor(ContextCompat.getColor(context, R.color.secondaryLightColor))
            holder.binding.fanPriceText.textSize = 24F
        } else {
            holder.binding.fanSaleText.visibility = View.GONE
            holder.binding.fanPriceText.setTextColor(ContextCompat.getColor(context, androidx.media.R.color.secondary_text_default_material_light))
            holder.binding.fanPriceText.textSize = 20F
        }
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}
