package com.example.jetpacknavigation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.example.jetpacknavigation.R
import com.example.jetpacknavigation.databinding.FragmentMainBinding
import com.example.jetpacknavigation.ui.base.NavigationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Stack

class MainFragment : NavigationFragment(), ViewPager.OnPageChangeListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: FragmentMainBinding
    private val backStack = Stack<Int>()

    private val childFragments = listOf(
        DescriptionHoldFragment(),
        DescriptionHoldFragment(),
        DescriptionHoldFragment()
    )

    private val indexToPage = listOf(
        R.id.g5_fragment,
        R.id.race_fragment,
        R.id.hanger_fragment
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.mainPager.adapter = ViewPagerAdapter(childFragmentManager, childFragments)
        binding.mainPager.addOnPageChangeListener(this)
        binding.mainPager.offscreenPageLimit = childFragments.size

        if (backStack.isEmpty()) {
            backStack.push(0)
        }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onBackPressed(): Boolean = when {
        !::binding.isInitialized -> false
        backStack.size > 1 -> processStackBackEvent()
        else -> false
    }

    private fun processStackBackEvent(): Boolean {
        backStack.pop()
        binding.mainPager.currentItem = backStack.peek()
        return true
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) = Unit

    override fun onPageScrollStateChanged(state: Int) = Unit

    override fun onPageSelected(position: Int) {
        val itemId = indexToPage[position]
        if (binding.bottomNavigationView.selectedItemId != itemId) {
            binding.bottomNavigationView.selectedItemId = itemId
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val position = indexToPage.indexOf(item.itemId)
        if (binding.mainPager.currentItem != position) {
            setItem(position)
        }
        return true
    }

    private fun setItem(position: Int) {
        binding.mainPager.currentItem = position
        backStack.remove(position)
        backStack.push(position)
    }

}
