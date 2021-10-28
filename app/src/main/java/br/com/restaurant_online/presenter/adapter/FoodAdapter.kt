package br.com.restaurant_online.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.luishenrique.restaurant_online.R
import br.com.restaurant_online.component_dto.Food
import br.com.luishenrique.restaurant_online.utils.toReais
import com.bumptech.glide.Glide

class FoodAdapter(
    private val items: List<br.com.restaurant_online.component_dto.Food>,
    private val onClick: (br.com.restaurant_online.component_dto.Food) -> Unit
): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val xTitle: TextView = itemView.findViewById(R.id.xTitle)
        private val xPrice: TextView = itemView.findViewById(R.id.xPrice)
        private val xImage: ImageView = itemView.findViewById(R.id.xImage)
        private val xItemFood: CardView = itemView.findViewById(R.id.xItemFood)

        fun bind(item: br.com.restaurant_online.component_dto.Food) {
            xTitle.text = item.name
            xPrice.text = item.price.toReais()
            Glide.with(itemView.context)
                .load(item.images[0].formats.small.url)
                .centerCrop()
                .into(xImage)

            xItemFood.setOnClickListener {
                onClick.invoke(item)
            }
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