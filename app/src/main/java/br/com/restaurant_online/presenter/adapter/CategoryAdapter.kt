package br.com.restaurant_online.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.luishenrique.restaurant_online.R
import br.com.restaurant_online.component_dto.Category

class CategoryAdapter(
    private val items: List<br.com.restaurant_online.component_dto.Category>,
    private val onClick: (br.com.restaurant_online.component_dto.Category) -> Unit
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    init {
        onClick.invoke(items[0])
    }

    inner class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val xName: TextView = itemView.findViewById(R.id.xName)
        private val xItemCategory: CardView = itemView.findViewById(R.id.xItemCategory)

        fun bind(item: br.com.restaurant_online.component_dto.Category) {
            xName.text = item.title

            xItemCategory.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_category, parent, false
        )
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}