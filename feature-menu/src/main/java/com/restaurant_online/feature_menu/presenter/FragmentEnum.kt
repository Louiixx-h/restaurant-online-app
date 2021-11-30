package com.restaurant_online.feature_menu.presenter

import androidx.fragment.app.FragmentManager
import br.com.restaurant_online.utils.replaceFragment
import com.restaurant_online.component_navigation.NavigationController
import com.restaurant_online.feature_menu.R

enum class FragmentEnum(name: String) {
    HOME("home") {
        override fun changeFragment(fragmentManager: FragmentManager) {
            NavigationController.menuItems?.get(HOME.name)?.getMenuItem()?.fragment?.let {
                replaceFragment(
                    fragmentManager,
                    R.id.xFragmentContainer,
                    it,
                    HOME.name
                )
            }
        }
    },
    CART("cart") {
        override fun changeFragment(fragmentManager: FragmentManager) {
            NavigationController.menuItems?.get(CART.name)?.getMenuItem()?.fragment?.let {
                replaceFragment(
                    fragmentManager,
                    R.id.xFragmentContainer,
                    it,
                    CART.name
                )
            }
        }
    },
    PROFILE("profile") {
        override fun changeFragment(fragmentManager: FragmentManager) {
            NavigationController.menuItems?.get(PROFILE.name)?.getMenuItem()?.fragment?.let {
                replaceFragment(
                    fragmentManager,
                    R.id.xFragmentContainer,
                    it,
                    PROFILE.name
                )
            }
        }
    };
    abstract fun changeFragment(fragmentManager: FragmentManager)
}