package com.restaurant_online.feature_home.presenter.presenter.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import br.com.restaurant_online.component_dto.Category
import br.com.restaurant_online.component_dto.Food
import com.restaurant_online.component_navigation.NavigationController
import com.restaurant_online.feature_home.R
import com.restaurant_online.feature_home.databinding.FragmentHomeBinding
import com.restaurant_online.feature_home.presenter.presenter.adapter.CategoryAdapter
import com.restaurant_online.feature_home.presenter.presenter.adapter.FoodAdapter
import com.restaurant_online.feature_home.presenter.presenter.viewmodel.HomeViewModel
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var mBinding: FragmentHomeBinding
    private val mViewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding = FragmentHomeBinding.bind(view)
        getCategories()
        setObserver()
    }

    private fun getCategories() {
        mViewModel.findAllCategories(useMock = true)
    }

    private fun setObserver() {
        mViewModel._categories.observe(viewLifecycleOwner) { response ->
            setRecyclerView(response)
        }
    }

    private fun setRecyclerView(categories: List<Category>) {
        mBinding.xRVFood.layoutManager = GridLayoutManager(requireContext(), 2)

        mBinding.xRVCategory.adapter = CategoryAdapter(categories) { category ->
            mBinding.xRVFood.adapter = FoodAdapter(category.foods) { food ->
                goToDetailsScreen(food)
            }
        }
    }

    private fun goToDetailsScreen(food: Food) {
        val bundle = Bundle()
        bundle.putString("food", Json.encodeToString(food))
        NavigationController.instance?.moduleFoodDetail()?.goToFoodDetail(
            parentFragmentManager, bundle
        )
    }
}