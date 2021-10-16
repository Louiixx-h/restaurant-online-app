package br.com.luishenrique.restaurantonline.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.luishenrique.restaurantonline.R
import br.com.luishenrique.restaurantonline.data.model.Category
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(
    private val items: List<Category>,
    private val onClick: (Category) -> Unit
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: Category) {
            itemView.xName.text = item.title

            itemView.xItemCategory.setOnClickListener {
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