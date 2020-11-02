package kr.khs.studyfarm.login_process.login

import android.content.Intent
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
import kr.khs.studyfarm.databinding.FragmentLoginBinding
import kr.khs.studyfarm.view.MainActivity

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        val viewModelFactory = LoginViewModelFactory()

        val viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        viewModel.response.observe(viewLifecycleOwner, Observer {
            if(it.code == 200.0) {
                Toast.makeText(context, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
        })

        viewModel.gotoSignUp.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignupFragment())
                viewModel.doneGoToSignUp()
            }
        })

        return binding.root
    }
}