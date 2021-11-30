package com.restaurant_online.component_navigation

import android.os.Bundle
import androidx.fragment.app.FragmentManager

interface FoodDetailNavigation {
    fun goToFoodDetail(parentFragmentManager: FragmentManager, bundle: Bundle)
}