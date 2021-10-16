package com.example.jetpacknavigation.ui.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(), OnBackPressedListener {

    private val callbackResolver by lazy {
        requireActivity() as CallbackResolver
    }

    override fun onBackPressed(): Boolean = false

    override fun onResume() {
        super.onResume()
        callbackResolver.addOnBackPressedListener(this)
    }

    override fun onPause() {
        super.onPause()
        callbackResolver.removeOnBackPressedListener(this)
    }

}
