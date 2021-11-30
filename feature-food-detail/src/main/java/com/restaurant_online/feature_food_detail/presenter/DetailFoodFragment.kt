package com.restaurant_online.feature_food_detail.presenter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import br.com.restaurant_online.component_dto.Food
import com.bumptech.glide.Glide
import br.com.restaurant_online.utils.toReais
import com.restaurant_online.component_navigation.NavigationController
import com.restaurant_online.feature_food_detail.R
import com.restaurant_online.feature_food_detail.databinding.FragmentDetailFoodBinding
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

class DetailFoodFragment : Fragment(R.layout.fragment_detail_food) {

    private lateinit var mBinding: FragmentDetailFoodBinding
    private var mFood: Food? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = FragmentDetailFoodBinding.bind(view)

        mFood = Json.decodeFromString<Food>(requireArguments().getString("food")!!)

        mFood.let {
            Glide.with(requireContext())
                .load(it?.images?.get(0)?.formats?.medium?.url)
                .centerCrop()
                .into(mBinding.xFoodImage)
            mBinding.xDetailFood.xName.text = it?.name
            mBinding.xDetailFood.xPrice.text = it?.price?.toReais()
            mBinding.xDetailFood.xDescription.text = it?.description
        }

        mBinding.xBack.setOnClickListener {
            parentFragmentManager.commit {
                remove(this@DetailFoodFragment)
            }
        }
    }

    override fun onDetach() {
        NavigationController.instance?.moduleMenu()?.showView()
        onDestroy()
        super.onDetach()
    }
}