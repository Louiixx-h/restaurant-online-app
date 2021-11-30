package com.restaurant_online.feature_menu

import android.content.Context
import android.content.Intent
import android.view.View
import com.restaurant_online.component_navigation.MenuNavigation
import com.restaurant_online.feature_menu.presenter.MenuActivity

class MenuNavigationImpl: MenuNavigation {

    override fun goToMenu(context: Context) {
        context.startActivity(Intent(context, MenuActivity::class.java))
    }

    override fun getFragmentLayout() = R.id.xFragmentContainer

    override fun showView() {
        MenuActivity.mBinding?.xBottomNavigationHome?.visibility = View.VISIBLE
        MenuActivity.mBinding?.xToolbarHome?.visibility = View.VISIBLE
    }

    override fun hideView() {
        MenuActivity.mBinding?.xBottomNavigationHome?.visibility = View.GONE
        MenuActivity.mBinding?.xToolbarHome?.visibility = View.GONE
    }
}