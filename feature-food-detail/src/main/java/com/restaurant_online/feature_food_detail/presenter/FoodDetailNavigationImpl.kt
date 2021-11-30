package com.restaurant_online.feature_food_detail.presenter

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import br.com.restaurant_online.utils.addFragment
import com.restaurant_online.component_navigation.FoodDetailNavigation
import com.restaurant_online.component_navigation.NavigationController

class FoodDetailNavigationImpl: FoodDetailNavigation {

    override fun goToFoodDetail(parentFragmentManager: FragmentManager, bundle: Bundle) {
        with(NavigationController.instance?.moduleMenu()) {
            this?.hideView()
            this?.getFragmentLayout()?.let {
                addFragment(
                    parentFragmentManager = parentFragmentManager,
                    fragmentContainer = it,
                    fragment = DetailFoodFragment(),
                    bundle = bundle,
                    tag = "details"
                )
            }
        }
    }
}