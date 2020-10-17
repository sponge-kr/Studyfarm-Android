package kr.khs.studyfarm.sign_up

import android.os.Bundle
import android.util.Log
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
import kr.khs.studyfarm.databinding.FragmentSignupSampleBinding
import kr.khs.studyfarm.network.ApiStatus

class SignupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentSignupSampleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_signup_sample, container, false
        )

        binding.lifecycleOwner = this

        val viewModelFactory = SignupViewModelFactory()

        val viewModel = ViewModelProvider(this, viewModelFactory).get(SignupViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.apiStatus.observe(viewLifecycleOwner, Observer {
            Log.d("SIGN_UP", when(it) {
                ApiStatus.LOADING -> "LOADING"
                ApiStatus.DONE -> "DONE"
                ApiStatus.ERROR -> "ERROR"
            }
            )
        })

        viewModel.response.observe(viewLifecycleOwner, Observer {
            it.let {
                if(it.code == 200.0) {
                    Toast.makeText(context, "회원가입이 되었습니다.", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(SignupSampleFragmentDirections.actionSignupSampleFragmentToSigninFragment())
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