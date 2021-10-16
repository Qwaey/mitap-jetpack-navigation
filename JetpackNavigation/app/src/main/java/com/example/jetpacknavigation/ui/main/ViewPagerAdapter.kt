package com.example.jetpacknavigation.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(
    childFragmentManager: FragmentManager,
    private val childFragments: List<Fragment>,
    private val titlesList: List<String>? = null
) : FragmentPagerAdapter(
    childFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    override fun getPageTitle(position: Int) = titlesList?.get(position)

    override fun getItem(position: Int) = childFragments[position]

    override fun getCount() = childFragments.size

}
