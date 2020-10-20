package kr.khs.studyfarm.login_process.sign_main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentSignMainBinding

class SignMainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentSignMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sign_main, container, false
        )

        val viewModelFactory = SignMainViewModelFactory()

        val viewModel = ViewModelProvider(this, viewModelFactory).get(SignMainViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        viewModel.goToSignUp.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(SignMainFragmentDirections.actionSignMainFragmentToSignEmailFragment())
                viewModel.doneSignUp()
            }
        })

        viewModel.goToLogin.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(SignMainFragmentDirections.actionSignMainFragmentToLoginFragment())
                viewModel.doneLogin()
            }
        })

        return binding.root
    }
}