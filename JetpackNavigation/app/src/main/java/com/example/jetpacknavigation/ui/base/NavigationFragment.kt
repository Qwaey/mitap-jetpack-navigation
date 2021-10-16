package com.example.jetpacknavigation.ui.base

import androidx.navigation.fragment.findNavController

abstract class NavigationFragment : BaseFragment() {

    protected val navController by lazy {
        findNavController()
    }

    override fun onBackPressed(): Boolean = navController.navigateUp()

}
