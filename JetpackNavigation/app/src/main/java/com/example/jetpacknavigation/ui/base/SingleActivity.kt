package com.example.jetpacknavigation.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpacknavigation.R
import java.util.LinkedHashSet

class SingleActivity : AppCompatActivity(), CallbackResolver {

    private var childBackPressedListeners: MutableSet<OnBackPressedListener> = LinkedHashSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun addOnBackPressedListener(listener: OnBackPressedListener) {
        childBackPressedListeners.add(listener)
    }

    override fun removeOnBackPressedListener(listener: OnBackPressedListener) {
        childBackPressedListeners.remove(listener)
    }

    override fun onBackPressed() {
        when {
            childBackPressedListeners.any { it.onBackPressed() } -> Unit
            else -> super.onBackPressed()
        }
    }

}
