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
            SignupInfoFragmentArgs.fromBundle(requireArguments()).email,
            SignupInfoFragmentArgs.fromBundle(requireArguments()).password,
            SignupInfoFragmentArgs.fromBundle(requireArguments()).nickname
        )

        viewModel = ViewModelProvider(this, viewModelFactory).get(SignupInfoViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.isSignupSuccess.observe(viewLifecycleOwner, Observer {
            it.let {
                if(it) {
                    Toast.makeText(context, "회원가입이 되었습니다.\n가입한 이메일로 로그인 해주세요.", Toast.LENGTH_SHORT).show()
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

        return binding.root
    }
}