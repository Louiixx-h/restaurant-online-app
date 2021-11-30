package com.restaurant_online.feature_home

import br.com.restaurant_online.component_dto.MenuItem
import com.restaurant_online.component_navigation.IMenuItem
import com.restaurant_online.feature_home.presenter.presenter.home.HomeFragment

class HomeMenuItemImpl: IMenuItem {

    override fun getMenuItem() = MenuItem(
            id = "home",
            fragment = HomeFragment()
    )
}