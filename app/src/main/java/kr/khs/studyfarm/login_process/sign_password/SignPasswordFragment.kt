package kr.khs.studyfarm.login_process.sign_password

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
import kr.khs.studyfarm.databinding.FragmentSignPasswordBinding

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


        viewModel.toast.observe(viewLifecycleOwner, Observer {
            if(it != "") {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                viewModel.doneToast()
            }
        })


        return binding.root
    }
}