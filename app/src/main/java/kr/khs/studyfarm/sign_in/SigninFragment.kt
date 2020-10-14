package kr.khs.studyfarm.sign_in

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
import kr.khs.studyfarm.databinding.FragmentSigninBinding
import kr.khs.studyfarm.sign_up.SignupFragmentDirections
import kr.khs.studyfarm.view.MainActivity

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

        viewModel.response.observe(viewLifecycleOwner, Observer {
            it.let {
                if(it.code == 200.0) {
                    val intent = Intent(activity, MainActivity::class.java)
                    startActivity(intent)
                    activity?.finish()
                }
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            it.let {
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }
}