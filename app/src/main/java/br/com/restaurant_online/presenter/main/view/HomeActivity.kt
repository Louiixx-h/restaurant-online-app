package br.com.restaurant_online.presenter.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import br.com.luishenrique.restaurant_online.R
import br.com.luishenrique.restaurant_online.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<HomeFragment>(R.id.xFragmentContainer)
            }
        }
        setBottomNavigation()
    }

    private fun setBottomNavigation() {
        mBinding.xBottomNavigationHome.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.xHome -> setFragment(HomeFragment(), "home")
                R.id.xCart -> setFragment(CartFragment(), "cart")
                R.id.xUser -> setFragment(UserFragment(), "profile")
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun setFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.commit {
            replace(R.id.xFragmentContainer, fragment, tag)
            setReorderingAllowed(true)
        }
    }

    fun showView() {
        mBinding.xToolbarHome.visibility = View.VISIBLE
        mBinding.xBottomNavigationHome.visibility = View.VISIBLE
    }

    fun hideView() {
        mBinding.xToolbarHome.visibility = View.GONE
        mBinding.xBottomNavigationHome.visibility = View.GONE
    }

    override fun onBackPressed() {
        super.onBackPressed()
        showView()
    }
}