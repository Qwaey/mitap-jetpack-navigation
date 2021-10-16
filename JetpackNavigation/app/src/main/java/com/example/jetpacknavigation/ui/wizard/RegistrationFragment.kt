package com.example.jetpacknavigation.ui.wizard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.jetpacknavigation.databinding.FragmentWithInputBinding
import com.example.jetpacknavigation.ui.base.NavigationFragment
import com.example.jetpacknavigation.ui.base.SimpleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : NavigationFragment() {

    private val viewModel by viewModel<SimpleViewModel>()
    private val args by navArgs<RegistrationFragmentArgs>()
    private lateinit var binding: FragmentWithInputBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWithInputBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.header.fragmentName.text = javaClass.simpleName
        binding.header.description.text = "Фрагмент может принимать в себя опциональный аргумент password string типа"

        if (args.password == null) {
            initFirstTry()
        } else {
            initSecondTry()
        }

        viewModel.navigation.observe(viewLifecycleOwner, {
            navController.navigate(it)
        })
    }

    private fun initFirstTry() {
        binding.header.title.text = "Экран регистрации ввод пароля"
        binding.button.text = "Придумать пароль"
        binding.button.setOnClickListener {
            viewModel.onRepeatPasswordClicked(
                currentPassword = binding.editText.text.toString()
            )
        }
    }

    private fun initSecondTry() {
        binding.header.title.text = "Экран регистрации повтор пароля"
        binding.editText.setText(args.password)
        binding.button.text = "Повторить пароль"
        binding.button.setOnClickListener {
            viewModel.onRegistrationEndClicked()
        }
    }

}
