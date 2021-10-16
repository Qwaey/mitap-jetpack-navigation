package com.example.jetpacknavigation.ui.wizard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jetpacknavigation.R
import com.example.jetpacknavigation.databinding.FragmentWithTwoButtonsBinding
import com.example.jetpacknavigation.ui.base.NavigationFragment
import com.example.jetpacknavigation.ui.base.SimpleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HoldStartFragment : NavigationFragment() {

    private val viewModel by viewModel<SimpleViewModel>()
    private lateinit var binding: FragmentWithTwoButtonsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWithTwoButtonsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.header.fragmentName.text = javaClass.simpleName
        binding.header.title.text = "Приветственный экран"
        binding.header.description.text = "Обычно тут начинается ветвление"

        with(binding.buttonFirst) {
            text = "Зарегистрироваться"
            setOnClickListener { viewModel.onRegistrationClicked() }
        }

        with(binding.buttonSecond) {
            text = "Войти"
            setOnClickListener { viewModel.onAuthClick() }
        }

        viewModel.navigation.observe(viewLifecycleOwner, {
            navController.navigate(it)
        })
    }

}
