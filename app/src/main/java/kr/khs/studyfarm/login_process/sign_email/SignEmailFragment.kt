package kr.khs.studyfarm.login_process.sign_email

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
import kr.khs.studyfarm.databinding.FragmentSignEmailBinding

class SignEmailFragment : Fragment() {

    lateinit var viewModel : SignEmailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentSignEmailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sign_email, container, false
        )

        binding.lifecycleOwner = this

        val viewModelFactory = SignEmailViewModelFactory()

        viewModel = ViewModelProvider(this, viewModelFactory).get(SignEmailViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.status.observe(viewLifecycleOwner, Observer {
            if(it == 1) {
                findNavController().navigate(
                    SignEmailFragmentDirections.actionSignEmailFragmentToSignPasswordFragment(
                        viewModel.email.get()!!
                    )
                )
                viewModel.defaultStatus()
            }
            else if(it == 2) {
                Toast.makeText(context, "이미 가입된 이메일입니다.\n로그인 화면으로 이동합니다.", Toast.LENGTH_SHORT).show()
                findNavController().navigate(
                    SignEmailFragmentDirections.actionSignEmailFragmentToLoginFragment()
                )
                viewModel.defaultStatus()
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