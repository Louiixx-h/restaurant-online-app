package com.restaurant_online.feature_menu.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.restaurant_online.component_navigation.IMenuItem
import com.restaurant_online.component_navigation.NavigationController
import com.restaurant_online.feature_menu.R
import com.restaurant_online.feature_menu.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMenuBinding
    private lateinit var mMenuItems: MutableMap<String, IMenuItem>

    companion object {
        var mBinding: ActivityMenuBinding? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        MenuActivity.mBinding = mBinding

        if (NavigationController.menuItems != null) {
            mMenuItems = NavigationController.menuItems!!
        }

        if (savedInstanceState == null) {
            with(supportFragmentManager.beginTransaction()) {
                setReorderingAllowed(true)
                mMenuItems["home"]?.let { add(R.id.xFragmentContainer, it.getMenuItem().fragment) }
                commit()
            }
        }
        setBottomNavigation()
    }

    private fun setBottomNavigation() {
        mBinding.xBottomNavigationHome.setOnItemSelectedListener { menuItem ->
            FragmentEnum.valueOf(menuItem.title.toString().uppercase()).changeFragment(supportFragmentManager)
            return@setOnItemSelectedListener true
        }
    }
}