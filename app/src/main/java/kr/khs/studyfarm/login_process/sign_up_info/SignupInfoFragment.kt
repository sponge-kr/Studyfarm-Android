package kr.khs.studyfarm.login_process.sign_up_info

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
import kr.khs.studyfarm.databinding.FragmentSignupInfoBinding
import kr.khs.studyfarm.login_process.sign_up.SignupFragmentDirections

class SignupInfoFragment : Fragment() {

    lateinit var viewModel : SignupInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentSignupInfoBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_signup_info, container, false
        )

        binding.lifecycleOwner = this

        val viewModelFactory = SignupInfoViewModelFactory(
            requireContext(),
            SignupInfoFragmentArgs.fromBundle(requireArguments()).seq,
            SignupInfoFragmentArgs.fromBundle(requireArguments()).cities,
            SignupInfoFragmentArgs.fromBundle(requireArguments()).interested
        )

        viewModel = ViewModelProvider(this, viewModelFactory).get(SignupInfoViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.isSignupSuccess.observe(viewLifecycleOwner, Observer {
            it.let {
                if(it) {
                    Toast.makeText(context, getString(R.string.signup_success), Toast.LENGTH_SHORT).show()
                    findNavController().navigate(SignupInfoFragmentDirections.actionSignupInfoFragmentToLoginFragment())
                }
            }
        })

        viewModel.toast.observe(viewLifecycleOwner, Observer {
            if(it != "") {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                viewModel.doneToast()
            }
        })

        viewModel.cityOrInterested.observe(viewLifecycleOwner, Observer {
            if(it != 0) {
                findNavController().navigate(SignupInfoFragmentDirections.actionSignupInfoFragmentToSelectFragment(
                    SignupInfoFragmentArgs.fromBundle(requireArguments()).seq,
                    it != 1,
                    SignupInfoFragmentArgs.fromBundle(requireArguments()).cities,
                    SignupInfoFragmentArgs.fromBundle(requireArguments()).interested
                ))
                viewModel.doneSelect()
            }
        })

        return binding.root
    }
}