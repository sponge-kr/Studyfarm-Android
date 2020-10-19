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
import kr.khs.studyfarm.databinding.FragmentSignupBinding
import kr.khs.studyfarm.network.ApiStatus
import kr.khs.studyfarm.setBackStackData

class SignupFragment : Fragment() {

    lateinit var viewModel : SignupViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentSignupBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_signup, container, false
        )

        binding.lifecycleOwner = this

        val viewModelFactory = SignupViewModelFactory()

        viewModel = ViewModelProvider(this, viewModelFactory).get(SignupViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.email.value = SignupFragmentArgs.fromBundle(requireArguments()).email

        viewModel.password.value = SignupFragmentArgs.fromBundle(requireArguments()).password

        viewModel.response.observe(viewLifecycleOwner, Observer {
            it.let {
                if(it.code == 200.0) {
                    Toast.makeText(context, "회원가입이 되었습니다.\n가입한 이메일로 로그인 해주세요.", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(SignupFragmentDirections.actionSignupFragmentToSignEmailFragment())
                }
            }
        })

        return binding.root
    }
}