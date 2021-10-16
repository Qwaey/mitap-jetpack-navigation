package com.example.jetpacknavigation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jetpacknavigation.databinding.FragmentDescriptionHolderBinding

class DescriptionHoldFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        FragmentDescriptionHolderBinding.inflate(inflater).root

}
