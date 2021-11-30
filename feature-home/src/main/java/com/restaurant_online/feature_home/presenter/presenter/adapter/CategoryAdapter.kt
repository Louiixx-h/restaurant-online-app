package com.restaurant_online.feature_home.presenter.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import br.com.restaurant_online.component_dto.Category
import com.restaurant_online.feature_home.R

class CategoryAdapter(
    private val items: List<Category>,
    private val onClick: (Category) -> Unit
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    init {
        onClick.invoke(items[0])
    }

    inner class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val xName: TextView = itemView.findViewById(R.id.xName)
        private val xItemCategory: View = itemView.findViewById(R.id.xItemCategory)

        fun bind(item: Category) {
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
        if (position <= items.size-1) holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}