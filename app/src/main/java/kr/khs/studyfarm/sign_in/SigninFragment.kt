package kr.khs.studyfarm.sign_in

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
import kr.khs.studyfarm.databinding.FragmentSigninBinding
import kr.khs.studyfarm.sign_up.SignupFragmentDirections

class SigninFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentSigninBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_signin, container, false
        )

        binding.lifecycleOwner = this

        val viewModelFactory = SigninViewModelFactory()

        val viewModel = ViewModelProvider(this, viewModelFactory).get(SigninViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.signUpBtnClicked.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(SigninFragmentDirections.actionSigninFragmentToSignupFragment())
                viewModel.doneSignupBtnClicked()
            }
        })

        return binding.root
    }
}