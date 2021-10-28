package br.com.restaurant_online.presenter.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import br.com.luishenrique.restaurant_online.R
import br.com.restaurant_online.component_dto.Category
import br.com.restaurant_online.component_dto.Food
import br.com.luishenrique.restaurant_online.databinding.FragmentHomeBinding
import br.com.luishenrique.restaurant_online.presenter.adapter.CategoryAdapter
import br.com.luishenrique.restaurant_online.presenter.adapter.FoodAdapter
import br.com.luishenrique.restaurant_online.presenter.main.viewmodel.RestaurantViewModel
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var mBinding: FragmentHomeBinding
    private val mViewModel: RestaurantViewModel by viewModel()

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

    private fun setRecyclerView(categories: List<br.com.restaurant_online.component_dto.Category>) {
        mBinding.xRVFood.layoutManager = GridLayoutManager(requireContext(), 2)

        mBinding.xRVCategory.adapter = CategoryAdapter(categories) { category ->
            mBinding.xRVFood.adapter = FoodAdapter(category.foods) { food ->
                goToDetailsScreen(food)
            }
        }
    }

    private fun goToDetailsScreen(food: br.com.restaurant_online.component_dto.Food) {
        val bundle = Bundle()
        bundle.putString("food", Json.encodeToString(food))
        parentFragmentManager.commit {
            add<DetailFoodFragment>(R.id.xFragmentContainer, args = bundle)
            addToBackStack("detail")
            setReorderingAllowed(true)
            (activity as HomeActivity).hideView()
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as HomeActivity).showView()
    }
}