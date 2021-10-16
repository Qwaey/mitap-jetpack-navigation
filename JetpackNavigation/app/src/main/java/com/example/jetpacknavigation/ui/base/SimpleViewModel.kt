package com.example.jetpacknavigation.ui.base

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.jetpacknavigation.ui.wizard.HoldStartFragmentDirections
import com.example.jetpacknavigation.ui.wizard.RegistrationFragmentDirections
import com.example.jetpacknavigation.utils.SingleLiveEvent

class SimpleViewModel : ViewModel() {

    val navigation = SingleLiveEvent<NavDirections>()

    fun onRegistrationClicked() {
        navigation.value = HoldStartFragmentDirections.toRegistration()
    }

    fun onAuthClick() {
        navigation.value = HoldStartFragmentDirections.toMainFragment()
    }

    fun onRepeatPasswordClicked(currentPassword: String) {
        navigation.value = RegistrationFragmentDirections.toRepeatPassword(
            password = currentPassword
        )
    }

    fun onRegistrationEndClicked() {
        navigation.value = RegistrationFragmentDirections.toMainFragment()
    }

}
