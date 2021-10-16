package br.com.luishenrique.restaurantonline.ui.main.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.luishenrique.restaurantonline.R
import br.com.luishenrique.restaurantonline.data.model.Category
import br.com.luishenrique.restaurantonline.ui.adapter.CategoryAdapter
import br.com.luishenrique.restaurantonline.ui.adapter.FoodAdapter
import br.com.luishenrique.restaurantonline.ui.main.viewmodel.RestaurantViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: RestaurantViewModel by viewModel()
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getCategories()
        setObserver()
    }

    private fun getCategories() {
        viewModel.findAllCategories(useMock = true)
    }

    private fun setObserver() {
        viewModel._categories.observe(viewLifecycleOwner) { response ->
            setRecyclerView(response)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setRecyclerView(categories: List<Category>) {
        foodAdapter = FoodAdapter(categories[0].foods)
        xRVFood.layoutManager = GridLayoutManager(requireContext(), 2)
        xRVFood.adapter = foodAdapter

        xRVCategory.adapter = CategoryAdapter(categories) {
            xRVFood.adapter = FoodAdapter(it.foods)
            foodAdapter.notifyDataSetChanged()
        }
    }
}