package com.example.jetpacknavigation.ui.base

interface CallbackResolver {

    fun addOnBackPressedListener(listener: OnBackPressedListener)

    fun removeOnBackPressedListener(listener: OnBackPressedListener)

}
