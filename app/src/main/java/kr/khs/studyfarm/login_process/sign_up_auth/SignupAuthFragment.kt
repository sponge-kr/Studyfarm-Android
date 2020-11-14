package kr.khs.studyfarm.login_process.sign_up_auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.FragmentSignupAuthBinding

class SignupAuthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentSignupAuthBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_signup_auth, container, false
        )

        binding.lifecycleOwner = this

        val viewModelFactory = SignupAuthViewModelFactory(SignupAuthFragmentArgs.fromBundle(requireArguments()).email)

        val viewModel = ViewModelProvider(this, viewModelFactory).get(SignupAuthViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.nextBtnClicked.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(
                    SignupAuthFragmentDirections.actionSignupAuthFragmentToSignupInfoFragment(
                        SignupAuthFragmentArgs.fromBundle(requireArguments()).email,
                        SignupAuthFragmentArgs.fromBundle(requireArguments()).password,
                        SignupAuthFragmentArgs.fromBundle(requireArguments()).nickname,
                        null,
                        null
                    )
                )
                viewModel.doneNextBtnClicked()
            }
        })

        viewModel.toast.observe(viewLifecycleOwner, Observer {
            if(it != "") {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                viewModel.doneToast()
            }
        })

        return binding.root
    }

}