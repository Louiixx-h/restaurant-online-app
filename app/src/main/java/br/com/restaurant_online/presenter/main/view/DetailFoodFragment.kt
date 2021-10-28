package br.com.restaurant_online.presenter.main.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import br.com.luishenrique.restaurant_online.R
import br.com.restaurant_online.component_dto.Food
import com.bumptech.glide.Glide
import br.com.luishenrique.restaurant_online.databinding.FragmentDetailFoodBinding
import br.com.luishenrique.restaurant_online.utils.toReais
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

class DetailFoodFragment : Fragment(R.layout.fragment_detail_food) {

    private lateinit var mBinding: FragmentDetailFoodBinding
    private var mFood: br.com.restaurant_online.component_dto.Food? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = FragmentDetailFoodBinding.bind(view)

        mFood = Json.decodeFromString<br.com.restaurant_online.component_dto.Food>(requireArguments().getString("food")!!)
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
}