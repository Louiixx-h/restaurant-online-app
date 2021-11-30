package br.com.restaurant_online.utils

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun replaceFragment(
    fragmentManager: FragmentManager,
    @IdRes fragmentContainer: Int,
    fragment: Fragment,
    tag: String
) {
    with(fragmentManager.beginTransaction()) {
        replace(fragmentContainer, fragment, tag)
        setReorderingAllowed(true)
        commit()
    }
}

fun addFragment(
    parentFragmentManager: FragmentManager,
    @IdRes fragmentContainer: Int,
    fragment: Fragment,
    bundle: Bundle? = null,
    tag: String
) {
    with(parentFragmentManager.beginTransaction()) {
        if (bundle != null) {
            fragment.arguments = bundle
        }
        add(fragmentContainer, fragment)
        addToBackStack(tag)
        setReorderingAllowed(true)
        commit()
    }
}