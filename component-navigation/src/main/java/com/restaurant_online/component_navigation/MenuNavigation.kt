package com.restaurant_online.component_navigation

import android.content.Context
import androidx.annotation.IdRes

interface MenuNavigation {
    fun goToMenu(context: Context)
    @IdRes fun getFragmentLayout(): Int
    fun showView()
    fun hideView()
}
