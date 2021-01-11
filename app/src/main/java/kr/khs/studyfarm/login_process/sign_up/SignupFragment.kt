package kr.khs.studyfarm.login_process.sign_up

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
import kr.khs.studyfarm.databinding.FragmentSignupBinding
import kr.khs.studyfarm.dialog
import kr.khs.studyfarm.login_process.agreement_bottomsheet.AgreementFragment
import kr.khs.studyfarm.network.ApiStatus

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

        val viewModelFactory = SignupViewModelFactory(requireContext())

        viewModel = ViewModelProvider(this, viewModelFactory).get(SignupViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.status.observe(viewLifecycleOwner, Observer {
            if(it == 1) {
                findNavController().navigate(
                    SignupFragmentDirections.actionSignupFragmentToAgreementFragment(
                        viewModel.email.get().toString(),
                        viewModel.password.get().toString(),
                        viewModel.nickname.get().toString())
                )
                viewModel.defaultStatus()
            }
            else if(it == 2) {
                Toast.makeText(context, getString(R.string.signup_duplicateEmail), Toast.LENGTH_SHORT).show()
                findNavController().navigate(
                    SignupFragmentDirections.actionSignupFragmentToLoginFragment()
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