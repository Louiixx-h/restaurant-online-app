package br.com.luishenrique.restaurantonline.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.luishenrique.restaurantonline.R
import br.com.luishenrique.restaurantonline.data.model.Food
import br.com.luishenrique.restaurantonline.utils.BASE_URL_IMG
import br.com.luishenrique.restaurantonline.utils.toReais
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_food.view.*

class FoodAdapter(
    private val items: List<Food>
): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: Food) {
            itemView.xTitle.text = item.name
            itemView.xPrice.text = item.price.toReais()
            Glide.with(itemView.context)
                .load(item.images[0].formats.small.url)
                .centerCrop()
                .into(itemView.xImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_food, parent, false
        )
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}