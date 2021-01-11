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
import kr.khs.studyfarm.dialog
import kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementFragmentArgs
import kr.khs.studyfarm.network.ApiStatus

class SignupAuthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentSignupAuthBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_signup_auth, container, false
        )

        binding.lifecycleOwner = this

        val viewModelFactory = SignupAuthViewModelFactory(
            requireContext(),
            SignupAuthFragmentArgs.fromBundle(requireArguments()).email
        )

        val viewModel = ViewModelProvider(this, viewModelFactory).get(SignupAuthViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.nextBtnClicked.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(
                    SignupAuthFragmentDirections.actionSignupAuthFragmentToSignupInfoFragment(
                        SignupAuthFragmentArgs.fromBundle(requireArguments()).seq,
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

        viewModel.apiStatus.observe(viewLifecycleOwner, Observer {
            if(it == ApiStatus.LOADING) {
                dialog.onLoadingDialog(requireActivity())
            }
            else if(dialog.loadingDialog != null && dialog.loadingDialog!!.isShowing) {
                dialog.offLoadingDialog()
            }
        })

        return binding.root
    }

}