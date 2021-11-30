package com.restaurant_online.feature_cart

import br.com.restaurant_online.component_dto.MenuItem
import com.restaurant_online.component_navigation.IMenuItem
import com.restaurant_online.feature_cart.presenter.CartFragment

class CartMenuItemImpl: IMenuItem {

    override fun getMenuItem() = MenuItem (
            id = "cart",
            fragment = CartFragment()
    )
}