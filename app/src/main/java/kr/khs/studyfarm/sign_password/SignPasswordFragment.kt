package kr.khs.studyfarm.sign_password

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentSignPasswordBinding
import kr.khs.studyfarm.isEmailValidate
import kr.khs.studyfarm.isPasswordValidate
import kr.khs.studyfarm.view.MainActivity

class SignPasswordFragment : Fragment() {

    lateinit var viewModel : SignPasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentSignPasswordBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sign_password, container, false
        )

        binding.lifecycleOwner = this

        val email = SignPasswordFragmentArgs.fromBundle(requireArguments()).email

        val viewModelFactory = SignPasswordViewModelFactory(email)

        viewModel = ViewModelProvider(this, viewModelFactory).get(SignPasswordViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.signupProcess.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(SignPasswordFragmentDirections.actionSignPasswordFragmentToSignupFragment(viewModel.email.value!!, viewModel.password.get()!!))
                viewModel.doneSignupProcess()
            }
        })


        return binding.root
    }
}